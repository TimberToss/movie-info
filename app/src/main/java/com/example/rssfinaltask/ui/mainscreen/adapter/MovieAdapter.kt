package com.example.rssfinaltask.ui.mainscreen.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.rssfinaltask.data.model.Movie


class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder.create(parent)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bindData(getItem(position))
}
