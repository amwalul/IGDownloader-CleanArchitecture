/*
 * Created by Amwalul Ikhsani on 7/29/20 5:27 PM
 * Copyright (c) 2020. All rights reserved.
 */

package com.amwa.igdownloader.ui.base

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amwa.domain.model.Failure
import com.amwa.domain.model.ResultWrapper
import com.amwa.domain.model.Success
import com.amwa.igdownloader.R
import kotlinx.coroutines.launch

abstract class BaseViewModel(protected val context: Context) : ViewModel() {

    protected fun <T> executeUseCase(
        viewState: MutableLiveData<Resource<T>> = MutableLiveData(),
        source: suspend () -> ResultWrapper<T>
    ) {
        viewState.value = Resource.loading(null)

        viewModelScope.launch {
            val resource = handleResult(source())
            viewState.postValue(resource)
        }
    }

    protected fun executeUseCase(action: suspend () -> Unit) {
        viewModelScope.launch { action() }
    }

    private fun <T> handleResult(result: ResultWrapper<T>): Resource<T> {
        return when (result) {
            is Success -> Resource.success(result.data)
            Failure.GenericError -> Resource.error(context.getString(R.string.generic_error), null)
            Failure.TimeoutError -> Resource.error(context.getString(R.string.rto_error), null)
            Failure.NetworkError -> Resource.error(context.getString(R.string.network_error), null)
            Failure.HttpError -> Resource.error(context.getString(R.string.link_not_found_error), null)
            Failure.TransactionError -> Resource.error(context.getString(R.string.save_media_error), null)
        }
    }
}