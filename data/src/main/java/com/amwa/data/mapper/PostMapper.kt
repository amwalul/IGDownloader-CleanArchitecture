/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.mapper

import com.amwa.data.remote.model.PostResponse
import com.amwa.domain.model.Post

object PostMapper : DomainMapper<PostResponse, Post> {

    override fun mapToDomain(type: PostResponse) = with(type.graphql?.shortcodeMedia!!) {
        Post(
            shortcode,
            if (isVideo!!) videoUrl else displayUrl,
            isVideo,
            sidecarToChildren?.edges?.map {
                with(it.node!!) {
                    Post(shortcode, if (isVideo!!) videoUrl else displayUrl, isVideo)
                }
            }
        )
    }
}