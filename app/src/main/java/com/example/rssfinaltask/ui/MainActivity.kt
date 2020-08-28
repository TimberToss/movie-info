package com.example.rssfinaltask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.rssfinaltask.R
import com.example.rssfinaltask.ui.mainscreen.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            replace(
                R.id.main_container,
                MainFragment.newInstance(),
                MainFragment.TAG
            )
        }
    }
}
