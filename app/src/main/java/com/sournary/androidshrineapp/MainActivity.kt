package com.sournary.androidshrineapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = container as NavHostFragment
        val navController = navHost.navController
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.login_dest -> toolbar.visibility = View.GONE
                R.id.menu_dest -> toolbar.visibility = View.VISIBLE
            }
        }
    }
}
