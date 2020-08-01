/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.datasource.media.impl

import com.amwa.data.datasource.media.MediaLocalDataSource
import com.amwa.data.local.storage.MediaFileManager
import com.amwa.data.mapper.MediaEntityFileMapper
import com.amwa.data.mapper.MediaFileEntityMapper
import com.amwa.domain.model.Media
import javax.inject.Inject

class MediaLocalDataSourceImpl @Inject constructor(
    private val fileManager: MediaFileManager
) : MediaLocalDataSource {
    override fun saveMediaFile(media: Media) {
        fileManager.saveMedia(MediaEntityFileMapper.mapToFile(media))
    }

    override fun saveMediaFiles(mediaList: List<Media>) {
        fileManager.saveMediaList(mediaList)
    }

    override fun getAllMediaFiles() = fileManager.getAllMedia().map {
        MediaFileEntityMapper.mapToDomain(it)
    }
}