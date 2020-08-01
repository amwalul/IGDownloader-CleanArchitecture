/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.datasource.media

import com.amwa.domain.model.Media

interface MediaRemoteDataSource {
    suspend fun getMedia(mediaUrl: String): Media
    suspend fun getMediaList(mediaUrls: List<String>): List<Media>
}