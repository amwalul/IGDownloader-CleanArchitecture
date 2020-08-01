/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.di.module

import com.amwa.data.common.Constants.BASE_URL
import com.amwa.data.remote.ApiService
import com.amwa.data.remote.ServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BASE_URL)
}