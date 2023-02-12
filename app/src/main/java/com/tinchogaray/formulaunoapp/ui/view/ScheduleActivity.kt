package com.tinchogaray.formulaunoapp.ui.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.databinding.ActivitySchedulesListBinding
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule
import com.tinchogaray.formulaunoapp.ui.adapter.ScheduleAdapter
import com.tinchogaray.formulaunoapp.ui.viewmodel.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchedulesListBinding
    private lateinit var raceScheduleAdapter: ScheduleAdapter
    private lateinit var yearAdapter: ArrayAdapter<String>

    private val raceScheduleViewModel: ScheduleViewModel by viewModels()
    private var raceSchedule = mutableListOf<RaceSchedule>()

    private lateinit var autocomplete: AutoCompleteTextView
    private var year = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObserver()
        initDropdown()
        getYearRaceSchedule(year.first())
        initRecyclerView()
    }


    private fun initRecyclerView() {
        raceScheduleAdapter = ScheduleAdapter(raceSchedule)
        with(binding.rvSchedules) {
            layoutManager = LinearLayoutManager(context)
            adapter = raceScheduleAdapter
        }

    }

    private fun initDropdown() {
        with(year) {
            clear()
            addAll(raceScheduleViewModel.getAvailableYears())
        }
        autocomplete = binding.dropdownYearMenu.autoCompleteYearTxt
        yearAdapter = ArrayAdapter(this, R.layout.year_list_item_dropdown, year)
        autocomplete.setAdapter(yearAdapter)
        autocomplete.setOnItemClickListener { parent, view, position, id ->
            val year = parent.getItemAtPosition(position).toString()
            getYearRaceSchedule(year)
        }
        autocomplete.setText(yearAdapter.getItem(0).toString(), false)
    }

    private fun updateRecyclerView(raceScheduleList: List<RaceSchedule>) {
        with(raceSchedule) {
            clear()
            addAll(raceScheduleList)
        }
        raceScheduleAdapter.notifyDataSetChanged()
    }


    private fun setObserver() {
        raceScheduleViewModel.raceScheduleList.observe(this, Observer {
            updateRecyclerView(it)
        })
    }

    private fun getYearRaceSchedule(year: String) {
        raceScheduleViewModel.getYearRaceSchedule(year)
    }
}