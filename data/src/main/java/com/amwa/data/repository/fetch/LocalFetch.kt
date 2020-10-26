package com.amwa.data.repository.fetch

import com.amwa.domain.model.ResultWrapper

interface LocalFetch : Fetch {
    suspend fun <T> safeTransaction(action: suspend () -> T): ResultWrapper<T>
}