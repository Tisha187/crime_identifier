package com.example.crimeidentifier

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav=findViewById<BottomNavigationView>(R.id.bottomnaviagationview)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home1 -> {
                    loadFragment(home_fragment())
                    return@setOnItemSelectedListener true
                }
                R.id.Evidence->{
                    loadFragment(Evidence_fragment())
                    return@setOnItemSelectedListener  true

                }
                R.id.classification-> {
                    loadFragment(classification())
                    return@setOnItemSelectedListener true
                }
                R.id.profile-> {
                    loadFragment(profile_fragment())
                    return@setOnItemSelectedListener true
                }


                else -> false
            }
        }
    }



private  fun loadFragment(fragment: Fragment){
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.nav_host_fragment,fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}
}