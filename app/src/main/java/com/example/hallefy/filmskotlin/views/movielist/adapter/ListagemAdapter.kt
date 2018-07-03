package com.example.hallefy.filmskotlin.views.movielist.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.ViewGroup
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.utils.inflate

class ListagemAdapter(val context: Context,
                      private val movies : ArrayList<Movie>) :
        Adapter<RecyclerView.ViewHolder>(){

    fun addMovie(movie: List<Movie>) {
        movies.removeAt(movies.size - 1)
        notifyItemRemoved(movies.size - 1)
        movies.addAll(movie)
        notifyItemInserted(movies.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM -> {
                ListagemViewHolder(context, parent.inflate(R.layout.list_row_films))
            }
            else -> {
                ListagemViewHolder(context, parent.inflate(R.layout.list_row_films))
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType) {
            ITEM -> {
                (holder as ListagemViewHolder).bind(movies[position])
            }
        }
    }

    companion object {
        val ITEM = 0
    }
}