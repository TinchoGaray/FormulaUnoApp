package com.tinchogaray.formulaunoapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tinchogaray.formulaunoapp.databinding.FragmentResultsBinding
import com.tinchogaray.formulaunoapp.domain.model.FastestLapDriver
import com.tinchogaray.formulaunoapp.domain.model.PodiumDriver
import com.tinchogaray.formulaunoapp.domain.model.RaceResult
import com.tinchogaray.formulaunoapp.domain.model.mapper.RaceResultMapper
import com.tinchogaray.formulaunoapp.ui.adapter.FastestLapAdapter
import com.tinchogaray.formulaunoapp.ui.adapter.PodiumAdapter
import com.tinchogaray.formulaunoapp.ui.viewmodel.ResultsViewModel
import dagger.hilt.android.AndroidEntryPoint

const val YEAR_BUNDLE = "param_year"
const val ROUND_BUNDLE = "param_round"

@AndroidEntryPoint
class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private var year: String? = null
    private var round: String? = null

    private lateinit var podiumAdapter: PodiumAdapter
    private lateinit var fastestLapAdapter: FastestLapAdapter

    private val resultsViewModel: ResultsViewModel by viewModels()
    private var raceResult = mutableListOf<RaceResult>()
    private var podiumDriverList = mutableListOf<PodiumDriver>()
    private var fastestLapDriverList = mutableListOf<FastestLapDriver>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            year = it.getString(YEAR_BUNDLE)
            round = it.getString(ROUND_BUNDLE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()
        getPodium()
        initRecyclerViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObserver() {
        resultsViewModel.raceResultList.observe(viewLifecycleOwner, Observer {
            updateRecyclerViews(it)
        })
    }

    private fun initRecyclerViews() {
        initPodiumRV()
        initFastestLapRV()
    }

    private fun initPodiumRV() {
        podiumAdapter = PodiumAdapter(podiumDriverList) {
            //TODO agregar logica del onClick de esa lista
        }
        with(binding.rvPodium) {
            layoutManager = LinearLayoutManager(context)
            adapter = podiumAdapter
        }
    }

    private fun initFastestLapRV() {
        fastestLapAdapter = FastestLapAdapter(fastestLapDriverList)
        with(binding.rvFastestLap) {
            layoutManager = LinearLayoutManager(context)
            adapter = fastestLapAdapter
        }
    }

    private fun updateRecyclerViews(result: RaceResult) {
        updatePodiumRV(result)
        updateFastestLapRV(result)
    }

    private fun updatePodiumRV(result: RaceResult) {
        with(podiumDriverList) {
            clear()
            addAll(RaceResultMapper().fromRaceResultToPodiumDriver(result))
        }
        podiumAdapter.notifyDataSetChanged()
    }

    private fun updateFastestLapRV(result: RaceResult) {
        with(fastestLapDriverList) {
            clear()
            addAll(RaceResultMapper().fromRaceResultToFastestLap(result))
        }
        fastestLapAdapter.notifyDataSetChanged()
    }

    private fun getPodium() {
        if (!year.isNullOrEmpty() && !round.isNullOrEmpty()) {
            resultsViewModel.getResult(year!!, round!!)
        }
    }
}
