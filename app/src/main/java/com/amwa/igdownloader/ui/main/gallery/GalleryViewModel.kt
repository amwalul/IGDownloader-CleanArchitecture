/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.main.gallery

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.amwa.domain.interaction.media.impl.GetAllMediaUseCaseImpl
import com.amwa.domain.model.Media
import com.amwa.igdownloader.ui.base.BaseViewModel
import com.amwa.igdownloader.ui.base.Resource
import dagger.hilt.android.qualifiers.ApplicationContext

class GalleryViewModel @ViewModelInject constructor(
    @ApplicationContext
    context: Context,
    private val getAllMediaUseCase: GetAllMediaUseCaseImpl
) : BaseViewModel(context) {

    val allMedia = MutableLiveData<Resource<List<Media>>>()

    fun getAllMedia() {
        executeUseCase(allMedia) {
            getAllMediaUseCase()
        }
    }
}