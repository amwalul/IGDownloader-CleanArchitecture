/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.interaction.post

import com.amwa.domain.model.Post
import com.amwa.domain.model.ResultWrapper

interface GetPostUseCase {
    suspend operator fun invoke(shortcode: String): ResultWrapper<Post>
}