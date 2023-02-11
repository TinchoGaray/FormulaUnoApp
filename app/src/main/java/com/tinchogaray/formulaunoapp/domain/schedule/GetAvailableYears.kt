package com.tinchogaray.formulaunoapp.domain.schedule

import com.tinchogaray.formulaunoapp.data.YearsRepository
import javax.inject.Inject

class GetAvailableYears @Inject constructor(private val repository: YearsRepository) {

    operator fun invoke(): List<String> {
        return repository.getAvailableYears()
    }
}