/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.local.storage

import com.amwa.data.local.storage.model.MediaFile
import com.amwa.domain.model.Media

interface MediaFileManager {
    fun saveMedia(media: MediaFile)
    fun saveMediaList(mediaList: List<Media>)
    fun getAllMedia(): List<MediaFile>
}