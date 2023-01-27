package com.tinchogaray.formulaunoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinchogaray.formulaunoapp.data.model.Drivers
import com.tinchogaray.formulaunoapp.domain.GetDrivers
import com.tinchogaray.formulaunoapp.domain.GetRandomDriver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DriversViewModel @Inject constructor(
    private val getDrivers: GetDrivers,
    private val getRandomDriver: GetRandomDriver
    ) : ViewModel() {

    val driverModel = MutableLiveData<Drivers>()
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
        isLoading.postValue(true)
        val driver = getRandomDriver()
        driver?.let {
            driverModel.postValue(it)
        }
        isLoading.postValue(false)
    }
}