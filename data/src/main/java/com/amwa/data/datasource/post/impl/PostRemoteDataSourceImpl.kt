/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.datasource.post.impl

import com.amwa.data.common.coroutine.CoroutineContextProvider
import com.amwa.data.datasource.post.PostRemoteDataSource
import com.amwa.data.mapper.PostMapper
import com.amwa.data.remote.ApiService
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(
    private val contextProvider: CoroutineContextProvider,
    private val apiService: ApiService
) : PostRemoteDataSource {
    override suspend fun getPost(shortcode: String) = withContext(contextProvider.io) {
        val response = apiService.getPost(shortcode)
        PostMapper.mapToDomain(response)
    }
}