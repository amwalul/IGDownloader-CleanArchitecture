/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.datasource.media.impl

import com.amwa.data.common.coroutine.CoroutineContextProvider
import com.amwa.data.datasource.media.MediaRemoteDataSource
import com.amwa.data.mapper.MediaMapper
import com.amwa.data.remote.ApiService
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MediaRemoteDataSourceImpl @Inject constructor(
    private val contextProvider: CoroutineContextProvider,
    private val apiService: ApiService
) : MediaRemoteDataSource {
    override suspend fun getMedia(mediaUrl: String) = withContext(contextProvider.io) {
        val response = apiService.getMedia(mediaUrl)
        MediaMapper.mapToDomain(response)
    }

    override suspend fun getMediaList(mediaUrls: List<String>) = withContext(contextProvider.io) {
        mediaUrls.map { url ->
            val response = apiService.getMedia(url)
            MediaMapper.mapToDomain(response)
        }
    }
}