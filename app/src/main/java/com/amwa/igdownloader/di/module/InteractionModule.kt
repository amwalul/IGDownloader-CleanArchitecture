/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.di.module

import com.amwa.domain.interaction.media.GetAllMediaUseCase
import com.amwa.domain.interaction.media.GetMediaListUseCase
import com.amwa.domain.interaction.media.GetMediaUseCase
import com.amwa.domain.interaction.media.impl.GetAllMediaUseCaseImpl
import com.amwa.domain.interaction.media.impl.GetMediaListUseCaseImpl
import com.amwa.domain.interaction.media.impl.GetMediaUseCaseImpl
import com.amwa.domain.interaction.post.GetPostUseCase
import com.amwa.domain.interaction.post.impl.GetPostUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class InteractionModule {

    @Binds
    @Singleton
    abstract fun provideGetPostUseCase(
        getPostUseCaseImpl: GetPostUseCaseImpl
    ): GetPostUseCase

    @Binds
    @Singleton
    abstract fun provideGetMediaUseCase(
        getMediaUseCaseImpl: GetMediaUseCaseImpl
    ): GetMediaUseCase

    @Binds
    @Singleton
    abstract fun provideGetMediaListUseCase(
        getMediaListUseCaseImpl: GetMediaListUseCaseImpl
    ): GetMediaListUseCase

    @Binds
    @Singleton
    abstract fun provideGetAllMediaUseCase(
        getAllMediaUseCaseImpl: GetAllMediaUseCaseImpl
    ): GetAllMediaUseCase
}