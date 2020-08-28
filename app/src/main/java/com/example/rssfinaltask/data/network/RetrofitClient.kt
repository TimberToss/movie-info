package com.example.rssfinaltask.data.network

import com.example.rssfinaltask.data.Constants.BASE_URL_V3
import org.koin.core.KoinComponent
import org.koin.core.get
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient : KoinComponent {

//    private const val API_KEY = "b64d6b0f-582b-4890-b207-b65b0c8864d2"
//    private const val API_KEY_HEADER = "x-api-key"
//    private const val BASE_URL = "https://api.thecatapi.com/"

    fun getMovieClient(): MovieService {

//        val headerInterceptor = Interceptor {
//            val request: Request = it.request().newBuilder()
//                .header(API_KEY_HEADER, API_KEY)
//                .build()
//            it.proceed(request)
//        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL_V3)
            .client(get())
            .addConverterFactory(get())
            .build()
            .create(MovieService::class.java)
    }

//    fun getMovieImageClient(): MovieImageService {
//        return Retrofit.Builder()
//            .baseUrl(BASE_IMAGE_URL)
//            .client(get())
//            .addConverterFactory(get())
//            .build()
//            .create(MovieImageService::class.java)
//    }
}
