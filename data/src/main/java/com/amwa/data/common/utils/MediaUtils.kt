/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.common.utils

object MediaUtils {

    fun getFileName(shortcode: String, format: String): String {
        return "IG_$shortcode.$format"
    }
}