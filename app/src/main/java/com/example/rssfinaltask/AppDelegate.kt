package com.example.rssfinaltask

import android.app.Application
import com.example.rssfinaltask.di.repositoryModule
import com.example.rssfinaltask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppDelegate)
            modules(repositoryModule, viewModelModule)
        }
    }
}
