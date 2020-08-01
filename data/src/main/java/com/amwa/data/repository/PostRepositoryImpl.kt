/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.repository

import com.amwa.data.common.utils.Connectivity
import com.amwa.data.datasource.post.PostRemoteDataSource
import com.amwa.domain.model.Post
import com.amwa.domain.model.ResultWrapper
import com.amwa.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    connectivity: Connectivity,
    private val postRemoteDataSource: PostRemoteDataSource
) : BaseRepository(connectivity), PostRepository {

    override suspend fun getPost(shortcode: String): ResultWrapper<Post> {
        return fetchData { postRemoteDataSource.getPost(shortcode) }
    }
}