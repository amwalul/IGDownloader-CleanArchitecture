/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.di.module

import com.amwa.data.common.utils.Connectivity
import com.amwa.data.common.utils.ConnectivityImpl
import com.amwa.data.repository.MediaRepositoryImpl
import com.amwa.data.repository.PostRepositoryImpl
import com.amwa.data.repository.fetch.LocalFetch
import com.amwa.data.repository.fetch.RemoteFetch
import com.amwa.data.repository.fetch.impl.LocalFetchImpl
import com.amwa.data.repository.fetch.impl.RemoteFetchImpl
import com.amwa.domain.repository.MediaRepository
import com.amwa.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideConnectivity(
        connectivity: ConnectivityImpl
    ): Connectivity

    @Binds
    @Singleton
    abstract fun providePostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository

    @Binds
    @Singleton
    abstract fun provideMediaRepository(
        mediaRepositoryImpl: MediaRepositoryImpl
    ): MediaRepository

    @Binds
    @Singleton
    abstract fun provideLocalFetch(
        localFetchImpl: LocalFetchImpl
    ): LocalFetch

    @Binds
    @Singleton
    abstract fun provideRemoteFetch(
        remoteFetchImpl: RemoteFetchImpl
    ): RemoteFetch
}