package com.example.rssfinaltask.ui.mainscreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.rssfinaltask.data.model.Movie

class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
        oldItem == newItem
}
