package com.innov.sherehify.activities

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.innov.sherehify.R
import com.innov.sherehify.fragments.SplashScreen
import com.innov.sherehify.fragments.signUp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.add(R.id.splashcontainer, SplashScreen(),"dashmainFragment").commitAllowingStateLoss()


    }
}