package com.amwa.data.repository.fetch.impl

import com.amwa.data.common.utils.Connectivity
import com.amwa.data.repository.fetch.LocalFetch
import com.amwa.data.repository.fetch.RemoteFetch
import com.amwa.domain.model.Failure
import com.amwa.domain.model.ResultWrapper
import com.amwa.domain.model.Success
import com.amwa.domain.model.chain
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class RemoteFetchImpl @Inject constructor(
    private val connectivity: Connectivity,
    private val localFetch: LocalFetch
) : RemoteFetch {
    override suspend fun <T> fetchData(source: suspend () -> T) = safeFetch(source)

    override suspend fun <T> fetchData(
        source: suspend () -> T,
        cacheAction: suspend (T) -> Unit
    ) = safeFetch(source).chain { result ->
        localFetch.safeTransaction { result.apply { cacheAction(this) } }
    }

    override suspend fun <T> safeFetch(action: suspend () -> T): ResultWrapper<T> =
        if (connectivity.hasNetworkAccess()) {
            try {
                Success(action())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is SocketTimeoutException -> Failure.TimeoutError
                    is IOException -> Failure.NetworkError
                    is HttpException -> Failure.HttpError
                    else -> {
                        Failure.GenericError
                    }
                }
            }
        } else Failure.NetworkError
}