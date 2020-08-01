/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.di.module

import com.amwa.data.datasource.media.MediaLocalDataSource
import com.amwa.data.datasource.media.MediaRemoteDataSource
import com.amwa.data.datasource.media.impl.MediaLocalDataSourceImpl
import com.amwa.data.datasource.media.impl.MediaRemoteDataSourceImpl
import com.amwa.data.datasource.post.PostRemoteDataSource
import com.amwa.data.datasource.post.impl.PostRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun providePostRemoteDataSource(
        postRemoteDataSourceImpl: PostRemoteDataSourceImpl
    ): PostRemoteDataSource

    @Binds
    @Singleton
    abstract fun provideMediaRemoteDataSource(
        mediaRemoteDataSourceImpl: MediaRemoteDataSourceImpl
    ): MediaRemoteDataSource

    @Binds
    @Singleton
    abstract fun provideMediaLocalDataSource(
        mediaLocalDataSourceImpl: MediaLocalDataSourceImpl
    ): MediaLocalDataSource
}