/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.common.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

object PermissionUtils {
    fun requestPermissions(fragment: Fragment, requestCode: Int, vararg permissions: String) {
        fragment.requestPermissions(permissions, requestCode)
    }

    fun permissionsGranted(context: Context, vararg permissions: String): Boolean {
        val grantedPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }

        return grantedPermissions.isNotEmpty()
    }

    fun requestPermissions(activity: Activity, requestCode: Int, vararg permissions: String) {
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }
}