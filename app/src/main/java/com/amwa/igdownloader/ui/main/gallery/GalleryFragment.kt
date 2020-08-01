/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.main.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.amwa.igdownloader.R
import com.amwa.igdownloader.common.Constants
import com.amwa.igdownloader.ui.base.BaseFragment
import com.amwa.igdownloader.ui.base.Resource
import com.eazypermissions.common.model.PermissionResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_gallery.*

@AndroidEntryPoint
class GalleryFragment : BaseFragment(R.layout.fragment_gallery) {

    private val viewModel by viewModels<GalleryViewModel>()

    private lateinit var galleryAdapter: GalleryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        checkGalleryPermissions()
        initObservers()
    }

    private fun initViews() {
        galleryAdapter = GalleryAdapter()
        rvGallery.adapter = galleryAdapter
        rvGallery.setHasFixedSize(true)
    }

    fun checkGalleryPermissions() {
        requestStoragePermissions(Constants.RC_PERMISSIONS_LOAD_GALLERY, ::handleGalleryPermissionsResult)
    }

    private fun handleGalleryPermissionsResult(result: PermissionResult) {
        when (result) {
            is PermissionResult.PermissionGranted -> viewModel.getAllMedia()
            is PermissionResult.ShowRational -> showDialogMessage(R.string.need_permission_error) {
                checkGalleryPermissions()
                it.dismiss()
            }
            else -> {
                // do nothing
            }
        }
    }

    private fun initObservers() {
        viewModel.allMedia.observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        val data = it.data!!
                        galleryAdapter.submitList(data)
                    }
                    Resource.Status.ERROR -> {
                    }
                    Resource.Status.LOADING -> {
                    }
                }
            }
        })
    }

    interface Interaction {
        fun onMediaDownloaded()
    }
}