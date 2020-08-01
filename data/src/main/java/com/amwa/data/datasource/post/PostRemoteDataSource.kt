/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.datasource.post

import com.amwa.domain.model.Post

interface PostRemoteDataSource {
    suspend fun getPost(shortcode: String): Post
}