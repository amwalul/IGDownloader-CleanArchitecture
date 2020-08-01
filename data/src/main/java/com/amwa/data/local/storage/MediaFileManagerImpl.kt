/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.local.storage

import com.amwa.data.common.Constants
import com.amwa.data.local.storage.model.MediaFile
import com.amwa.domain.model.Media
import java.io.File
import javax.inject.Inject

class MediaFileManagerImpl @Inject constructor() : BaseFileManager(), MediaFileManager {

    override val basePath: File
        get() = File(Constants.BASE_MEDIA_PATH)

    override fun saveMedia(media: MediaFile) = with(media) {
        val file = File(basePath, fileName!!)
        saveFile(file, stream!!)
    }

    override fun saveMediaList(mediaList: List<Media>) {
        mediaList.forEach { media ->
            with(media) {
                val file = File(basePath, fileName!!)
                saveFile(file, stream!!)
            }
        }
    }

    override fun getAllMedia(): List<MediaFile> = basePath.listFiles()
        ?.filter { file ->
            file.absolutePath.endsWith(Constants.FORMAT_MP4) || file.absolutePath.endsWith(Constants.FORMAT_JPG)
        }?.sortedWith(Comparator { o1: File, o2: File ->
            o1.lastModified().compareTo(o2.lastModified())
        })
        ?.asReversed()
        ?.map { file ->
            MediaFile(file.name, file, file.inputStream())
        }
        ?: emptyList()
}