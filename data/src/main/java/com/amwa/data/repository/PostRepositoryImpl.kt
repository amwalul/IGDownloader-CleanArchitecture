/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.repository

import com.amwa.data.datasource.post.PostRemoteDataSource
import com.amwa.data.repository.fetch.RemoteFetch
import com.amwa.domain.model.Post
import com.amwa.domain.model.ResultWrapper
import com.amwa.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postRemoteDataSource: PostRemoteDataSource,
    private val remoteFetch: RemoteFetch
) : PostRepository {

    override suspend fun getPost(shortcode: String): ResultWrapper<Post> {
        return remoteFetch.fetchData { postRemoteDataSource.getPost(shortcode) }
    }
}