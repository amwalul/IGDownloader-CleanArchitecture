package com.amwa.data.repository.fetch

import com.amwa.domain.model.ResultWrapper

interface RemoteFetch : Fetch {
    suspend fun <T> fetchData(
        source: suspend () -> T,
        cacheAction: suspend (T) -> Unit
    ): ResultWrapper<T>

    suspend fun <T> safeFetch(action: suspend () -> T): ResultWrapper<T>
}