/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.repository

import com.amwa.domain.model.Media
import com.amwa.domain.model.Post
import com.amwa.domain.model.ResultWrapper

interface MediaRepository {
    suspend fun getMedia(post: Post): ResultWrapper<Media>
    suspend fun getMediaList(posts: List<Post>): ResultWrapper<List<Media>>
    suspend fun getAllMedia(): ResultWrapper<List<Media>>
}