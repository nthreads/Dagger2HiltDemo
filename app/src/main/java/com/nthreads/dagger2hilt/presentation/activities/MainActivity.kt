package com.nthreads.dagger2hilt.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nthreads.dagger2hilt.R
import com.nthreads.dagger2hilt.app.LogApplication
import com.nthreads.dagger2hilt.navigator.AppNavigator
import com.nthreads.dagger2hilt.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = (applicationContext as LogApplication).serviceLocator.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}
