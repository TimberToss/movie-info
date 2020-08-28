package com.example.rssfinaltask.ui.mainscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rssfinaltask.data.model.Movie
import com.example.rssfinaltask.databinding.ItemMovieBinding

class MovieViewHolder(
    private val binding: ItemMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(movie: Movie) {
        with(binding) {
            Glide.with(root)
                .load(BASE_IMAGE_URL + POSTER_SIZES[2] + movie.posterPath)
                .into(poster)

            title.text = movie.title
        }
    }

    companion object {

        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"

        private val POSTER_SIZES = listOf(
            "w92",
            "w154",
            "w185",
            "w342",
            "w500",
            "w780",
            "original"
        )

        fun create(parent: ViewGroup) =
            MovieViewHolder(
                ItemMovieBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }
}
