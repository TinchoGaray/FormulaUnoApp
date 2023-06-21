package com.tinchogaray.formulaunoapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.databinding.FragmentResultsBinding
import com.tinchogaray.formulaunoapp.ui.adapter.PodiumAdapter

class ResultsFragment : Fragment() {

    private val _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    private lateinit var podiumAdapter: PodiumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_results, container, false)
    }
}
