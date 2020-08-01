/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.domain.model

import java.io.InputStream

data class Media(
    var fileName: String? = null,
    val path: String? = null,
    val stream: InputStream? = null
)