/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.local.storage

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

abstract class BaseFileManager {

    abstract val basePath: File

    private fun createBasePath() {
        if (!basePath.exists()) {
            basePath.mkdir()
        }
    }

    protected fun saveFile(file: File, fileStream: InputStream) {
        createBasePath()

        fileStream.use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }
    }
}