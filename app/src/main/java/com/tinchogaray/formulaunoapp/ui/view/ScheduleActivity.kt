package com.tinchogaray.formulaunoapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tinchogaray.formulaunoapp.databinding.ActivitySchedulesListBinding
import com.tinchogaray.formulaunoapp.ui.viewmodel.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulesListBinding

    private val raceScheduleViewModel: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        raceScheduleViewModel.onCreate()
    }
}