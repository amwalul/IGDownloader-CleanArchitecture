/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.remote

import com.amwa.data.remote.model.PostResponse
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiService {

    @GET("p/{shortcode}/?__a=1")
    suspend fun getPost(
        @Path("shortcode")
        shortcode: String
    ): PostResponse

    @GET
    suspend fun getMedia(
        @Url
        mediaUrl: String
    ): ResponseBody
}