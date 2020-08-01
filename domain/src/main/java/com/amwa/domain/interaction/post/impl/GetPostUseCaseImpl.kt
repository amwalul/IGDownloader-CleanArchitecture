/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.interaction.post.impl

import com.amwa.domain.interaction.post.GetPostUseCase
import com.amwa.domain.repository.PostRepository
import javax.inject.Inject

class GetPostUseCaseImpl @Inject constructor(private val postRepository: PostRepository) : GetPostUseCase {
    override suspend operator fun invoke(shortcode: String) = postRepository.getPost(shortcode)
}