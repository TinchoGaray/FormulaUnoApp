package com.tinchogaray.formulaunoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule
import com.tinchogaray.formulaunoapp.domain.schedule.GetYearSchedule
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(
    private val getYearSchedule: GetYearSchedule
) : ViewModel() {

    val raceSchedule = MutableLiveData<RaceSchedule>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getYearSchedule("2022")

            if (result.isNotEmpty()) {
                raceSchedule.postValue(result.first())
                viewModelScope.launch {
                    isLoading.postValue(false)
                }
            }
        }
    }


}