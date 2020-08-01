/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.base

import android.Manifest
import android.content.DialogInterface
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.amwa.igdownloader.R
import com.amwa.igdownloader.common.extensions.gone
import com.amwa.igdownloader.common.extensions.visible
import com.amwa.igdownloader.common.utils.PermissionUtils
import com.eazypermissions.common.model.PermissionResult
import com.eazypermissions.coroutinespermission.PermissionManager

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    fun showMessage(@StringRes message: Int) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    fun showMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    fun showDialogMessage(message: String?, action: (DialogInterface) -> Unit = { it.dismiss() }) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.message)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, which ->
                action(dialog)
            }.show()
    }

    fun showDialogMessage(@StringRes message: Int, action: (DialogInterface) -> Unit = { it.dismiss() }) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.message)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, which ->
                action(dialog)
            }.show()
    }

    fun showLoading(progressBar: ProgressBar) {
        progressBar.visible()
    }

    fun hideLoading(progressBar: ProgressBar) {
        progressBar.gone()
    }

    fun storagePermissionsGranted(): Boolean {
        return PermissionUtils.permissionsGranted(
            requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    fun requestStoragePermissions(requestCode: Int, resultAction: (PermissionResult) -> Unit) {
        lifecycleScope.launchWhenStarted {
            val permissionResult = PermissionManager.requestPermissions(
                this@BaseFragment,
                requestCode,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )

            resultAction(permissionResult)
        }
    }
}