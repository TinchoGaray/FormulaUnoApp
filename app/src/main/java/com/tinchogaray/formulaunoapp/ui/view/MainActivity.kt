package com.tinchogaray.formulaunoapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.tinchogaray.formulaunoapp.databinding.ActivityMainBinding
import com.tinchogaray.formulaunoapp.ui.viewmodel.DriversViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val driversViewModel: DriversViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        driversViewModel.onCreate()

        driversViewModel.driverModel.observe(this, Observer {
            binding.tvDriverName.text = it.name + " " + it.lastName
            binding.tvDriverNumber.text = it.permanentNumber
        })

        driversViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener {
            driversViewModel.randomDriver()
        }
    }
}