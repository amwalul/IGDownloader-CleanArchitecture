/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.data.mapper

interface DomainMapper<E, D> {
    fun mapToDomain(type: E): D
}

interface DataMapper<E, D> {
    fun mapToData(type: E): D
}

interface FileMapper<E, D> {
    fun mapToFile(type: E): D
}