package com.example.rssfinaltask.di

import com.example.rssfinaltask.viewmodel.mainscreen.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainFragmentViewModel(get())
    }
}
