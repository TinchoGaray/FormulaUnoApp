package com.tinchogaray.formulaunoapp.ui.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.data.network.youtube.RaceHighlightsDelegate
import com.tinchogaray.formulaunoapp.databinding.FragmentRacesBinding
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule
import com.tinchogaray.formulaunoapp.ui.adapter.ScheduleAdapter
import com.tinchogaray.formulaunoapp.ui.viewmodel.ScheduleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RacesFragment : Fragment() {

    private var _binding: FragmentRacesBinding? = null
    private val binding get() = _binding!!

    private lateinit var raceScheduleAdapter: ScheduleAdapter
    private lateinit var yearAdapter: ArrayAdapter<String>

    private val raceScheduleViewModel: ScheduleViewModel by viewModels()
    private var raceSchedule = mutableListOf<RaceSchedule>()

    private lateinit var autocomplete: AutoCompleteTextView
    private var year = mutableListOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRacesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        initDropdown(view.context)
        getYearRaceSchedule(year.first())
        initRecyclerView(view.context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView(viewContext: Context) {
        raceScheduleAdapter = ScheduleAdapter(raceSchedule) {
            startActivity(RaceHighlightsDelegate().openYoutube(it.raceName, it.season))
        }
        with(binding.rvSchedules) {
            layoutManager = LinearLayoutManager(context)
            adapter = raceScheduleAdapter
        }

    }

    private fun initDropdown(context: Context) {
        with(year) {
            clear()
            addAll(raceScheduleViewModel.getAvailableYears())
        }
        autocomplete = binding.dropdownYearMenu.autoCompleteYearTxt
        yearAdapter = ArrayAdapter(context, R.layout.year_list_item_dropdown, year)
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
        raceScheduleViewModel.raceScheduleList.observe(viewLifecycleOwner, Observer {
            updateRecyclerView(it)
        })

        raceScheduleViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
            scrollToTop()
        })
    }

    private fun getYearRaceSchedule(year: String) {
        raceScheduleViewModel.getYearRaceSchedule(year)
    }

    private fun scrollToTop() {
        binding.rvSchedules.layoutManager?.scrollToPosition(0)
    }
}