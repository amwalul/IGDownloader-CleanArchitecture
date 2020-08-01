/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.interaction.media.impl

import com.amwa.domain.interaction.media.GetMediaUseCase
import com.amwa.domain.model.Post
import com.amwa.domain.repository.MediaRepository
import javax.inject.Inject

class GetMediaUseCaseImpl @Inject constructor(private val mediaRepository: MediaRepository) : GetMediaUseCase {
    override suspend operator fun invoke(post: Post) = mediaRepository.getMedia(post)
}