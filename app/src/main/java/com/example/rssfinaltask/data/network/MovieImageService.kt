package com.example.rssfinaltask.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface MovieImageService {

    @GET("{file_size}/{file_path}")
    suspend fun getImage(
        @Path("file_size") fileSize: String,
        @Path("file_path") filePath: String
    )
}
