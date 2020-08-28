package com.example.rssfinaltask.di

import com.example.rssfinaltask.data.repository.Repository
import com.example.rssfinaltask.data.repository.RepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

val repositoryModule = module {

    single<Repository> {
        RepositoryImpl()
    }

    single {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single<Converter.Factory> {
        MoshiConverterFactory.create()
    }
}
