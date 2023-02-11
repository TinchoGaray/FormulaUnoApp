package com.tinchogaray.formulaunoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule
import com.tinchogaray.formulaunoapp.domain.schedule.GetAvailableYears
import com.tinchogaray.formulaunoapp.domain.schedule.GetYearSchedule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getYearSchedule: GetYearSchedule,
    private val getAvailableYears: GetAvailableYears
) : ViewModel() {

    val raceScheduleList = MutableLiveData<List<RaceSchedule>>()
    val isLoading = MutableLiveData<Boolean>()

    /*
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
     */

    fun getYearRaceSchedule() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getYearSchedule("2022")

            if (result.isNotEmpty()) {
                raceScheduleList.postValue(result)
                viewModelScope.launch {
                    isLoading.postValue(false)
                }
            }
        }
    }

    fun getAvailableYears(): List<String> {
        return this.getAvailableYears.invoke()
    }

}