package com.ryutec.masterdetailfood.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.ryutec.masterdetailfood.R
import com.ryutec.masterdetailfood.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // settear la vista con databinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setNavController()

    }

    fun setNavController() {
        // Asignar el bottom nav
        val btmNav = binding.bottomNav
        // Instanciar un controllador
        val navControler = Navigation.findNavController(this, R.id.frag_host)
        // Settear el controlador a nuestro nav
        NavigationUI.setupWithNavController(btmNav, navControler)
    }
}