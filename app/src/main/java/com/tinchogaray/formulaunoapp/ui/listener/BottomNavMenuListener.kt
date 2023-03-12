package com.tinchogaray.formulaunoapp.ui.listener

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.ui.view.NewsFragment
import com.tinchogaray.formulaunoapp.ui.view.RacesFragment
import com.tinchogaray.formulaunoapp.ui.view.StandingFragment

class BottomNavMenuListener {

    fun createNavMenuListener(supportFragmentManager: FragmentManager): BottomNavigationView.OnNavigationItemSelectedListener {

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
