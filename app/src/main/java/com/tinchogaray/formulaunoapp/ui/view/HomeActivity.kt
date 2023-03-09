package com.tinchogaray.formulaunoapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navigation: BottomNavigationView

    private val navMenuListener = createNavMenuListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation = binding.navMenu
        navigation.setOnNavigationItemSelectedListener(navMenuListener)

        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.commit {
            replace<NewsFragment>(R.id.frameContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }

    private fun createNavMenuListener(): BottomNavigationView.OnNavigationItemSelectedListener {

        return BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.itemNews -> {
                    supportFragmentManager.commit {
                        replace<NewsFragment>(R.id.frameContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@OnNavigationItemSelectedListener true
                }

                R.id.itemStanding -> {
                    supportFragmentManager.commit {
                        replace<StandingFragment>(R.id.frameContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@OnNavigationItemSelectedListener true
                }

                R.id.itemRaces -> {
                    supportFragmentManager.commit {
                        replace<RacesFragment>(R.id.frameContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@OnNavigationItemSelectedListener true
                }
            }

            false
        }

    }
}