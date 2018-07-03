package com.example.hallefy.filmskotlin.views.movielist.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.utils.Constants
import com.example.hallefy.filmskotlin.utils.loadUrl
import com.example.hallefy.filmskotlin.views.moviedetail.ActivityDetalhes
import kotlinx.android.synthetic.main.list_row_films.view.*

class ListagemViewHolder(val context: Context, itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movies : Movie) {
        itemView.tvTitulo.text = movies.title
        itemView.tvRate.text = "Nota: ${movies.voteAverage}"
        itemView.ImageFilm.loadUrl(Constants.IMG_URL+movies.posterPath)

        itemView.relativeCard.setOnClickListener {
            requestDetail(movies.id)
        }
    }

    private fun requestDetail(id : Int) {
        val intent = Intent(context , ActivityDetalhes::class.java)
        val bundle = Bundle()

        bundle.putInt("id_movie",id)
        intent.putExtras(bundle)

        context.startActivity(intent)
    }
}