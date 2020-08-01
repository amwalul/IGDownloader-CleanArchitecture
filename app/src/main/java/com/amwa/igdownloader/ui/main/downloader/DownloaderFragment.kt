/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.main.downloader

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.amwa.data.common.Constants.BASE_URL
import com.amwa.igdownloader.R
import com.amwa.igdownloader.common.Constants
import com.amwa.igdownloader.common.extensions.gone
import com.amwa.igdownloader.common.extensions.visible
import com.amwa.igdownloader.common.utils.URLUtils
import com.amwa.igdownloader.ui.base.BaseFragment
import com.amwa.igdownloader.ui.base.Resource
import com.amwa.igdownloader.ui.main.gallery.GalleryFragment
import com.eazypermissions.common.model.PermissionResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_downloader.*

@AndroidEntryPoint
class DownloaderFragment(
    private val interaction: GalleryFragment.Interaction
) : BaseFragment(R.layout.fragment_downloader) {

    private val viewModel by viewModels<DownloaderViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObservers()
    }

    private fun initViews() {
        initListeners()
    }

    private fun initListeners() {
        btnDownload.setOnClickListener {
            checkMediaPermissions()
        }

        ivClear.setOnClickListener {
            resetInput()
        }

        etUrl.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                scrollView.post { scrollView.fullScroll(View.FOCUS_DOWN) }
                ivClear.visible()
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                scrollView.post { scrollView.fullScroll(View.FOCUS_DOWN) }
                ivClear.visible()
            }

            override fun afterTextChanged(s: Editable) {
                scrollView.post { scrollView.fullScroll(View.FOCUS_DOWN) }
                ivClear.visibility = if (etUrl.text.toString().isNotEmpty()) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        })
    }

    private fun checkMediaPermissions() {
        requestStoragePermissions(Constants.RC_PERMISSIONS_SAVE_MEDIA, ::handleMediaPermissionsResult)
    }

    private fun handleMediaPermissionsResult(result: PermissionResult) {
        when (result) {
            is PermissionResult.PermissionGranted -> downloadMedia()
            is PermissionResult.ShowRational -> {
                showDialogMessage(R.string.need_permission_error) {
                    checkMediaPermissions()
                    it.dismiss()
                }
            }
            else -> {
            }
        }
    }

    private fun initObservers() {
        viewModel.mediaList.observe(viewLifecycleOwner, Observer {
            it?.let {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        hideLoading(progressBar)

                        interaction.onMediaDownloaded()
                        Toast.makeText(context, getString(R.string.media_saved), Toast.LENGTH_SHORT).show()
                    }
                    Resource.Status.ERROR -> {
                        hideLoading(progressBar)
                        showMessage(it.message)
                    }
                    Resource.Status.LOADING -> {
                        showLoading(progressBar)
                    }
                }
            }
        })
    }

    private fun resetInput() {
        etUrl.text.clear()
        ivClear.gone()
    }

    private fun downloadMedia() {
        val postUrl = etUrl.text.toString()
        if (postUrl.isNotBlank() && URLUtils.isValidUrl(postUrl) && postUrl.startsWith(BASE_URL)) {
            val shortcode = URLUtils.getInstagramShortcode(postUrl)
            viewModel.getMediaList(shortcode)
        } else {
            showMessage(R.string.invalid_url_error)
        }
    }
}