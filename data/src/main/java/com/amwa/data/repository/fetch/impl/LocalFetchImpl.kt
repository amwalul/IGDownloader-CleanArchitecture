package com.amwa.data.repository.fetch.impl

import com.amwa.data.repository.fetch.LocalFetch
import com.amwa.domain.model.Failure
import com.amwa.domain.model.Success
import java.io.IOException
import javax.inject.Inject

class LocalFetchImpl @Inject constructor() : LocalFetch {
    override suspend fun <T> fetchData(source: suspend () -> T) = safeTransaction(source)

    override suspend fun <T> safeTransaction(action: suspend () -> T) =
        try {
            Success(action())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Failure.TransactionError
                else -> Failure.GenericError
            }
        }
}