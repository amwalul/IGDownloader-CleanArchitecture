/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.di.module

import com.amwa.data.local.storage.MediaFileManager
import com.amwa.data.local.storage.MediaFileManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class FileManagerModule {

    @Binds
    @Singleton
    abstract fun provideMediaFileManager(
        mediaFileManagerImpl: MediaFileManagerImpl
    ): MediaFileManager
}