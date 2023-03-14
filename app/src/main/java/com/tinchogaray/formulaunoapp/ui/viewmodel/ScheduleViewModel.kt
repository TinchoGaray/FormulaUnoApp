package com.tinchogaray.formulaunoapp.ui.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinchogaray.formulaunoapp.data.network.youtube.RaceHighlightsDelegate
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

    fun getYearRaceSchedule(year: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getYearSchedule(year)

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

    fun setOnHighlightsClickListener(fragment: Fragment, raceSchedule: RaceSchedule) {
        fragment.startActivity(RaceHighlightsDelegate().openYoutube(raceSchedule.raceName, raceSchedule.season))
    }
}