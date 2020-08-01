/*
 * Created by Amwalul Ikhsani on 7/29/20 4:53 PM
 * Copyright (c) 2020. All rights reserved.
 */

@file:Suppress("UNCHECKED_CAST")

package com.amwa.domain.model

sealed class ResultWrapper<out T>
data class Success<out T>(val data: T) : ResultWrapper<T>()
sealed class Failure<out T> : ResultWrapper<T>() {
    object GenericError : Failure<Nothing>()
    object TimeoutError : Failure<Nothing>()
    object NetworkError : Failure<Nothing>()
    object HttpError : Failure<Nothing>()
    object TransactionError : Failure<Nothing>()
}

inline fun <T, R> ResultWrapper<T>.chain(
    action: (T) -> ResultWrapper<R>
): ResultWrapper<R> = when (this) {
    is Success -> action(data)
    else -> this as ResultWrapper<R>
}

inline fun <T, R> ResultWrapper<T>.map(
    action: (T) -> R
): ResultWrapper<R> = when (this) {
    is Success -> Success(action(data))
    else -> this as ResultWrapper<R>
}

inline fun <T> ResultWrapper<T>.onSuccess(action: (T) -> Unit): ResultWrapper<T> {
    if (this is Success) action(data)
    return this
}

inline fun <T> ResultWrapper<T>.onFailure(action: () -> Unit) {
    if (this is Failure) action()
}