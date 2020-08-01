/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.local.storage.model

import java.io.File
import java.io.InputStream

data class MediaFile(
    val fileName: String? = null,
    val file: File? = null,
    val stream: InputStream? = null
)