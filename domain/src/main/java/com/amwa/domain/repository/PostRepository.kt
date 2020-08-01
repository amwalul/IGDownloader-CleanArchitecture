/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.repository

import com.amwa.domain.model.Post
import com.amwa.domain.model.ResultWrapper

interface PostRepository {
    suspend fun getPost(shortcode: String): ResultWrapper<Post>
}