package com.geektech.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.geektech.lovecalculator.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideActionBar()
        initBottomNav()
    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }

    private fun initBottomNav() {
        val bottomFragments = listOf(
            R.id.homeFragment,
            R.id.historyFragment,
            R.id.historyFragment
        )

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.historyFragment,
            )
        )

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            navView.isVisible = bottomFragments.contains(destination.id)
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}