/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.main.downloader

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.amwa.domain.interaction.media.impl.GetMediaListUseCaseImpl
import com.amwa.domain.interaction.media.impl.GetMediaUseCaseImpl
import com.amwa.domain.interaction.post.impl.GetPostUseCaseImpl
import com.amwa.domain.model.Media
import com.amwa.domain.model.chain
import com.amwa.domain.model.map
import com.amwa.igdownloader.ui.base.BaseViewModel
import com.amwa.igdownloader.ui.base.Resource
import dagger.hilt.android.qualifiers.ApplicationContext

class DownloaderViewModel @ViewModelInject constructor(
    @ApplicationContext
    context: Context,
    private val getPostUseCase: GetPostUseCaseImpl,
    private val getMediaUseCase: GetMediaUseCaseImpl,
    private val getMediaListUseCase: GetMediaListUseCaseImpl
) : BaseViewModel(context) {

    val mediaList = MutableLiveData<Resource<List<Media>>>()

    fun getMediaList(shortcode: String) {
        executeUseCase(mediaList) {
            getPostUseCase(shortcode).chain { post ->
                post.sidecars?.let { sidecars ->
                    getMediaListUseCase(sidecars)
                } ?: kotlin.run {
                    getMediaUseCase(post).map { listOf(it) }
                }
            }
        }
    }
}