package com.tinchogaray.formulaunoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinchogaray.formulaunoapp.domain.model.RaceResult
import com.tinchogaray.formulaunoapp.domain.result.GetResultForYearAndRound
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val getResultForYearAndRound: GetResultForYearAndRound
) : ViewModel() {

    val raceResultList = MutableLiveData<RaceResult>()
    val isLoading = MutableLiveData<Boolean>()

    fun getResult(year: String, round: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getResultForYearAndRound(year, round)

            raceResultList.postValue(result)
            viewModelScope.launch {
                isLoading.postValue(false)
            }
        }
    }

}
