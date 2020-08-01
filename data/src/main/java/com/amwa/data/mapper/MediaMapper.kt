/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.mapper

import com.amwa.data.local.storage.model.MediaFile
import com.amwa.domain.model.Media
import okhttp3.ResponseBody

object MediaMapper : DomainMapper<ResponseBody, Media> {
    override fun mapToDomain(type: ResponseBody): Media = with(type) {
        Media(stream = byteStream())
    }
}

object MediaFileEntityMapper : DomainMapper<MediaFile, Media> {
    override fun mapToDomain(type: MediaFile): Media = with(type) {
        Media(fileName, file?.absolutePath, stream)
    }
}

object MediaEntityFileMapper : FileMapper<Media, MediaFile> {
    override fun mapToFile(type: Media): MediaFile = with(type) {
        MediaFile(fileName, stream = stream)
    }
}
