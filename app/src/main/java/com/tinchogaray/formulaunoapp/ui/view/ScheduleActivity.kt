package com.tinchogaray.formulaunoapp.ui.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
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

    private val raceScheduleViewModel: ScheduleViewModel by viewModels()
    private var raceSchedule = mutableListOf<RaceSchedule>()
    private lateinit var autocomplete: AutoCompleteTextView
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private var year = mutableListOf<String>("2022", "2021", "2015")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchedulesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObserver()
        raceScheduleViewModel.getYearRaceSchedule()
        initRecyclerView()

        autocomplete = binding.dropdownYearMenu.autoCompleteYearTxt
        arrayAdapter = ArrayAdapter(this, R.layout.year_list_item_dropdown, year)
        autocomplete.setAdapter(arrayAdapter)
        autocomplete.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
        }
    }

    private fun initRecyclerView() {
        raceScheduleAdapter = ScheduleAdapter(raceSchedule)
        with(binding.rvSchedules) {
            layoutManager = LinearLayoutManager(context)
            adapter = raceScheduleAdapter
        }
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
}