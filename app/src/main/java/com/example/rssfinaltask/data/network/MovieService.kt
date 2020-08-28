package com.example.rssfinaltask.data.network

import com.example.rssfinaltask.data.Constants.API_KEY_V3
import com.example.rssfinaltask.data.Constants.BASE_URL_V3
import com.example.rssfinaltask.data.Constants.STANDARD_LOCALE
import com.example.rssfinaltask.data.model.TmdbResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY_V3,
        @Query("language") language: String = STANDARD_LOCALE
    ): TmdbResponse

//    @GET("v1/images/search")
//    suspend fun getCats(
//        @Query("limit") limit: Int,
//        @Query("page") page: Int,
//        @Query("size") size: String,
//        @Query("mime_types") mimeTypes: String,
//        @Query("order") order: String
//    ): List<Cat>

//    @GET("v1/images/{image_id}")
//    suspend fun getCatById(
//        @Path("image_id") id: String
//    ): Cat
}
