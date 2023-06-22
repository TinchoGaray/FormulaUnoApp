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
import com.tinchogaray.formulaunoapp.domain.model.PodiumDriver
import com.tinchogaray.formulaunoapp.domain.model.RaceResult
import com.tinchogaray.formulaunoapp.domain.model.RaceResultMapper
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

    private val resultsViewModel: ResultsViewModel by viewModels()
    private var raceResult = mutableListOf<RaceResult>()
    private var podiumDriverList: List<PodiumDriver>? = null

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
        initRecyclerView()
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

    private fun initRecyclerView() {
        podiumDriverList?.let {
            podiumAdapter = PodiumAdapter(it) {

            }
        }

        with(binding.rvPodium) {
            layoutManager = LinearLayoutManager(context)
            adapter = podiumAdapter
        }
    }

    private fun updateRecyclerViews(result: RaceResult) {
        podiumDriverList = RaceResultMapper().fromRaceResultToPodiumDriver(result)
        with(raceResult) {
            clear()
            add(result)
        }
        podiumAdapter.notifyDataSetChanged()
    }

    private fun getPodium() {
        if (!year.isNullOrEmpty() && !round.isNullOrEmpty()) {
            resultsViewModel.getResult(year!!, round!!)
            podiumDriverList = RaceResultMapper().fromRaceResultToPodiumDriver(raceResult.first())
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(year: String, round: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(YEAR_BUNDLE, year)
                    putString(ROUND_BUNDLE, round)
                }
            }
    }
}
