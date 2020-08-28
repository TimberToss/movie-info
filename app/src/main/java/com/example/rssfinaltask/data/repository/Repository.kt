package com.example.rssfinaltask.data.repository

import com.example.rssfinaltask.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getMovies(): Flow<List<Movie>>
}
