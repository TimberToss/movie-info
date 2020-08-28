package com.example.rssfinaltask.data.repository

import android.util.Log
import com.example.rssfinaltask.data.Constants.API_KEY_V3
import com.example.rssfinaltask.data.Constants.LOG_TAG
import com.example.rssfinaltask.data.network.RetrofitClient
import kotlinx.coroutines.flow.flow


class RepositoryImpl : Repository {

    fun log(msg: String) = Log.d(LOG_TAG, "[${Thread.currentThread().name}] $msg")

    override suspend fun getMovies() = flow {
        val movies = RetrofitClient.getMovieClient().getPopularMovies(1).movies
        log("before emit")
        emit(movies)
    }
}
