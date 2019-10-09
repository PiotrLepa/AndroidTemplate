package com.piotr.androidtemplate.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.piotr.androidtemplate.R
import kotlinx.android.synthetic.main.activity_main.toolbar

class MainActivity : AppCompatActivity() {

  private val navController: NavController by lazy {
    findNavController(R.id.navHostFragment)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    setupToolbar()
  }

  private fun setupToolbar() {
    toolbar.setupWithNavController(navController)
  }
}