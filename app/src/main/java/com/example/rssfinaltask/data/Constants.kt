package com.example.rssfinaltask.data

object Constants {

    const val LOG_TAG = "MY_TAG"

    const val API_KEY_V3 = "3a3f3301b337b22c02e34796361fd9ea"
    const val API_KEY_V4 =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzYTNmMzMwMWIzMzdiMjJjMDJlMzQ3OTYzNjFmZDllYSIsInN1YiI6IjVmMzE4ZjY3NTU5ZDIyMDAzNzdiZTZiMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.GuMgh3FxSDKKFk3N0uFEBLfU-BGA3CxGr8KpFZcwwtQ"

    // baseUrl must end in /
    const val BASE_URL_V3 = "https://api.themoviedb.org/3/"
    const val BASE_URL_V4 = "https://api.themoviedb.org/4/"

    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"

    const val STANDARD_LOCALE = "en-US"


    val BACKDROP_SIZES = listOf(
        "w300",
        "w780",
        "w1280",
        "original"
    )
    val LOGO_SIZES = listOf(
        "w45",
        "w92",
        "w154",
        "w185",
        "w300",
        "w500",
        "original"
    )
    val POSTER_SIZES = listOf(
        "w92",
        "w154",
        "w185",
        "w342",
        "w500",
        "w780",
        "original"
    )
    val PROFILE_SIZES = listOf(
        "w45",
        "w185",
        "h632",
        "original"
    )
    val STILL_SIZES = listOf(
        "w92",
        "w185",
        "w300",
        "original"
    )
}
