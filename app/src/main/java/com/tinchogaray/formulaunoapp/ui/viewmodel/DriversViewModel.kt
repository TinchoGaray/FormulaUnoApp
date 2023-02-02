package com.tinchogaray.formulaunoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinchogaray.formulaunoapp.domain.driver.GetDrivers
import com.tinchogaray.formulaunoapp.domain.driver.GetRandomDriver
import com.tinchogaray.formulaunoapp.domain.model.Driver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getDrivers: GetDrivers,
    private val getRandomDriver: GetRandomDriver
    ) : ViewModel() {

    val driverModel = MutableLiveData<Driver>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDrivers()

            if (result.isNotEmpty()) {
                driverModel.postValue(result.first())
                viewModelScope.launch {
                    isLoading.postValue(false)
                }
            }
        }
    }

    fun randomDriver() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val driver = getRandomDriver()
            driver?.let {
                driverModel.postValue(it)
            }
            isLoading.postValue(false)
        }
    }
}