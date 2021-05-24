package com.chevalierlab.apiexample.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chevalierlab.apiexample.data.api.ApiConfig
import com.chevalierlab.apiexample.data.api.ApiStatus
import com.chevalierlab.apiexample.data.model.DataResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _meal = MutableLiveData<DataResponse>()
    val meal: LiveData<DataResponse>
        get() = _meal

    private val _status = MutableLiveData<ApiStatus>()
    private val apiService = ApiConfig().service

    private suspend fun requestSeafoodList() = try {
        _status.postValue(ApiStatus.LOADING)
        _meal.postValue(apiService.getSeafood())
        _status.postValue(ApiStatus.FAILED)
    } catch (ex: Exception) {
        Log.d("GET_SEAFOOD", ex.localizedMessage!!)
        _status.postValue(ApiStatus.FAILED)
    }

    fun getSeafoodList() = viewModelScope.launch { requestSeafoodList() }
}