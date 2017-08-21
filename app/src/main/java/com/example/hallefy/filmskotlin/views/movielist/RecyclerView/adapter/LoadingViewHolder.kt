package com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar

/**
 * Created by hallefy on 21/08/17.
 */
class LoadingViewHolder(itemView: View, val progressBar: ProgressBar) : RecyclerView.ViewHolder(itemView) {

    fun bind() = with(itemView) {
        progressBar.isIndeterminate = true
    }


    fun unBind() = with(itemView) {
        progressBar.isIndeterminate = false
    }
}