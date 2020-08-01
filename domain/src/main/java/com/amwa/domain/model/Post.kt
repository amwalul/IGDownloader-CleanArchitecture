/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.model

data class Post(
    val shortcode: String? = null,
    val mediaUrl: String? = null,
    val isVideo: Boolean? = null,
    val sidecars: List<Post>? = null
)