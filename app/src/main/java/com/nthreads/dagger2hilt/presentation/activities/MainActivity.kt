package com.nthreads.dagger2hilt.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nthreads.dagger2hilt.R
import com.nthreads.dagger2hilt.navigator.AppNavigator
import com.nthreads.dagger2hilt.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
