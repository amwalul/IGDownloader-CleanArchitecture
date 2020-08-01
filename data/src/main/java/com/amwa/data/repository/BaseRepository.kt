/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.repository

import com.amwa.data.common.utils.Connectivity
import com.amwa.domain.model.Failure
import com.amwa.domain.model.ResultWrapper
import com.amwa.domain.model.Success
import com.amwa.domain.model.chain
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

abstract class BaseRepository(private val connectivity: Connectivity) {

    protected suspend fun <T> fetchData(source: suspend () -> T): ResultWrapper<T> = safeFetch(source)

    protected suspend fun <T> fetchLocalData(source: suspend () -> T): ResultWrapper<T> = safeTransaction(source)

    protected suspend fun <T> fetchData(
        source: suspend () -> T,
        cacheAction: suspend (T) -> Unit
    ): ResultWrapper<T> = safeFetch(source).chain { result ->
        safeTransaction { result.apply { cacheAction(this) } }
    }

    private suspend fun <T> safeFetch(action: suspend () -> T): ResultWrapper<T> {
        return if (connectivity.hasNetworkAccess()) {
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

    private suspend fun <T> safeTransaction(action: suspend () -> T): ResultWrapper<T> {
        return try {
            Success(action())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Failure.TransactionError
                else -> Failure.GenericError
            }
        }
    }
}