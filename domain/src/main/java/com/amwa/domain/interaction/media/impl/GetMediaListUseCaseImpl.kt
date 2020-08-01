/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.interaction.media.impl

import com.amwa.domain.interaction.media.GetMediaListUseCase
import com.amwa.domain.model.Post
import com.amwa.domain.repository.MediaRepository
import javax.inject.Inject

class GetMediaListUseCaseImpl @Inject constructor(private val mediaRepository: MediaRepository) : GetMediaListUseCase {
    override suspend operator fun invoke(posts: List<Post>) = mediaRepository.getMediaList(posts)
}