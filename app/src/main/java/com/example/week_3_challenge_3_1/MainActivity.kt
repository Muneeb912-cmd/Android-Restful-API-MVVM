package com.example.week_3_challenge_3_1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.week_3_challenge_3_1.databinding.ActivityMainBinding
import com.example.week_3_challenge_3_1.ui.RecyclerViewFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    private lateinit var drawerLayout: DrawerLayout
    private val fragmentManager = supportFragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Week3_Challenge)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Initialize DrawerLayout and Toolbar
        drawerLayout = binding.main
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // Initialize NavigationView and set its listener
        val navigationView = binding.navView
        navigationView.setNavigationItemSelectedListener(this)

        // Setup ActionBarDrawerToggle
        val toggle = actionBarDrawerToggle(toolbar)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //Recycler View Fragment
        setupRecyclerViewFragment()
    }

    private fun setupRecyclerViewFragment() {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, RecyclerViewFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun actionBarDrawerToggle(toolbar: Toolbar?) =
        ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )

    override fun onNavigationItemSelected(items: MenuItem): Boolean {
        when (items.itemId) {
            R.id.home -> {
                return true
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}
