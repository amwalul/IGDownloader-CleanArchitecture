/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amwa.igdownloader.R
import com.amwa.igdownloader.ui.main.downloader.DownloaderFragment
import com.amwa.igdownloader.ui.main.gallery.GalleryFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), GalleryFragment.Interaction {

    private lateinit var menuAdapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        menuAdapter = MenuAdapter(
            supportFragmentManager, 0,
            listOf(DownloaderFragment(this), GalleryFragment()),
            listOf(getString(R.string.downloader), getString(R.string.gallery))
        )
        vpMenu.adapter = menuAdapter

        tlMenu.setupWithViewPager(vpMenu)
    }

    override fun onMediaDownloaded() {
        val galleryFragment = menuAdapter.getItem(1) as GalleryFragment
        galleryFragment.checkGalleryPermissions()
    }
}