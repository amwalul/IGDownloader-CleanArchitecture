/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.common.utils

import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context

object ClipboardUtils {
    fun getTextClipboard(context: Context): String {
        return with((context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager)) {
            if (hasPrimaryClip() && primaryClipDescription!!.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                val item = primaryClip?.getItemAt(0)
                item?.text?.toString() ?: ""
            } else {
                ""
            }
        }
    }
}