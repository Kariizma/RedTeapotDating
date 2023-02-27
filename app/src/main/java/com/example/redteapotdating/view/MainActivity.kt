package com.example.redteapotdating.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.redteapotdating.R
import com.example.redteapotdating.databinding.ActivityMainBinding
import com.example.redteapotdating.viewmodels.DatingViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val viewModel: DatingViewModel by viewModels()
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //Retrieve the navController from the NavHost Fragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //Set up the action bar for use with the NavController
        setupActionBarWithNavController(navController)

        binding!!.button.setOnClickListener {
            viewModel.incrementButton()
        }
    }

    /**
     * Handles the navigation when the user chooses back from the action bar
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}