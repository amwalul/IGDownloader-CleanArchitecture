package com.amwa.data.repository.fetch

import com.amwa.domain.model.ResultWrapper

interface Fetch {
    suspend fun <T> fetchData(source: suspend () -> T): ResultWrapper<T>
}