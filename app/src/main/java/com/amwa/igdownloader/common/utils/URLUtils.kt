/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.common.utils

import android.util.Patterns

object URLUtils {

    fun isValidUrl(url: String): Boolean = Patterns.WEB_URL.matcher(url).matches()

    fun getInstagramShortcode(url: String): String = url.split("/")[4]
}