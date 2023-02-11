package com.tinchogaray.formulaunoapp.data

import com.tinchogaray.formulaunoapp.data.network.YearProvider
import javax.inject.Inject

class YearsRepository @Inject constructor(val provider: YearProvider) {

    fun getAvailableYears(): List<String> {
        return provider.getAllYears()
    }
}