package com.example.navigationapp.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigationapp.fragment.DashboardFragment
import com.example.navigationapp.R
import com.google.android.material.navigation.NavigationView
import com.example.navigationapp.fragment.Contact_us
import com.example.navigationapp.fragment.Login
import com.example.navigationapp.fragment.Places
import com.example.navigationapp.fragment.RatingFragment


class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var frameLayout: FrameLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var coordinatorLayout: CoordinatorLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initalizing above lateints
        drawerLayout=findViewById(R.id.drawerlayout)
        navigationView=findViewById(R.id.navigation_view)
        toolbar=findViewById(R.id.toolbar)
        coordinatorLayout=findViewById(R.id.coordinatorlayout)
        frameLayout=findViewById(R.id.framelayout)
        //Calling Toolbar
        setUpToolbar()
        // Default setting login as a default main fragment
        openLogin()
               // Hamburger icon creation
        val actionBarDrawerToggle=ActionBarDrawerToggle(this,drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // Navigation menu Listner and also their fragment directions from here

        navigationView.setNavigationItemSelectedListener {
        when(it.itemId)
        {
            R.id.Contact ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, Contact_us())
                    .commit()
                     supportActionBar?.title="Contact Us"
                drawerLayout.closeDrawers()

            }
            R.id.login ->{
                // here called by function instead of writing code again
                openLogin()
            }
            R.id.logout ->{Toast.makeText(this,"Logout Success",Toast.LENGTH_SHORT).show()
            drawerLayout.closeDrawers()}
            R.id.Rate ->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, RatingFragment())
                    .commit()
                supportActionBar?.title="Ratings"
                drawerLayout.closeDrawers()

            }
            R.id.Places ->{
                supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, Places())
                .commit()
                supportActionBar?.title="Places"
                drawerLayout.closeDrawers()
            }
            R.id.dashboard ->
            {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, DashboardFragment())
                    .commit()
                supportActionBar?.title="Dashboard"
                drawerLayout.closeDrawers()
            }
        }
            return@setNavigationItemSelectedListener true
        }

    }
fun setUpToolbar(){
    setSupportActionBar(toolbar)
    supportActionBar?.title="Travel Pack Kashmir"
    supportActionBar?.setHomeButtonEnabled(true)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    // OPen login fucntion and we will make it default fragment for our app


        fun openLogin(){
            val fragment= DashboardFragment()
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.framelayout, Login())
                .commit()
            drawerLayout.closeDrawers()
            supportActionBar?.title="Login"
            // no need to write another code
            navigationView.setCheckedItem(R.id.login)
        }
    //.addtobackstack replaced here by overriding function this
    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.framelayout)
        when(frag)
        {
            !is Login ->openLogin()
            else->super.onBackPressed()
        }

    }
}

