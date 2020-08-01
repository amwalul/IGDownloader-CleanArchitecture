/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.repository

import com.amwa.data.common.Constants
import com.amwa.data.common.utils.Connectivity
import com.amwa.data.common.utils.MediaUtils
import com.amwa.data.datasource.media.MediaLocalDataSource
import com.amwa.data.datasource.media.MediaRemoteDataSource
import com.amwa.domain.model.Media
import com.amwa.domain.model.Post
import com.amwa.domain.model.ResultWrapper
import com.amwa.domain.repository.MediaRepository
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    connectivity: Connectivity,
    private val mediaRemoteDataSource: MediaRemoteDataSource,
    private val mediaLocalDataSource: MediaLocalDataSource
) : BaseRepository(connectivity), MediaRepository {
    override suspend fun getMedia(post: Post): ResultWrapper<Media> = fetchData(
        source = {
            mediaRemoteDataSource.getMedia(post.mediaUrl!!)
        },
        cacheAction = { media ->
            mediaLocalDataSource.saveMediaFile(
                media.apply {
                    fileName = MediaUtils.getFileName(
                        post.shortcode!!,
                        if (post.isVideo!!) Constants.FORMAT_MP4 else Constants.FORMAT_JPG
                    )
                }
            )
        }
    )

    override suspend fun getMediaList(posts: List<Post>) = fetchData(
        source = {
            mediaRemoteDataSource.getMediaList(posts.map { it.mediaUrl!! })
        },
        cacheAction = { mediaList ->
            mediaList.forEachIndexed { index, media ->
                media.fileName = MediaUtils.getFileName(
                    posts[index].shortcode!!,
                    if (posts[index].isVideo!!) Constants.FORMAT_MP4 else Constants.FORMAT_JPG
                )
            }
            mediaLocalDataSource.saveMediaFiles(mediaList)
        }
    )

    override suspend fun getAllMedia(): ResultWrapper<List<Media>> = fetchLocalData {
        mediaLocalDataSource.getAllMediaFiles()
    }
}