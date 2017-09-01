package com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse

import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.moviedetail.ActivityDetalhes
import com.example.hallefy.filmskotlin.views.movielist.utils.loadUrl

/**
 * Created by hallefy on 17/08/17.
 */


class RecyclerHolder(view: View, internal var context: Context, val response: MoviesResponse) : RecyclerView.ViewHolder(view) {

    var title: TextView
    var rate: TextView
    var descricao: TextView
    var imageFilm: ImageView
    var relativeLayout: LinearLayout

    var bundle : Bundle? = Bundle()



    fun bind(films: MoviesResponse, position : Int){
        title.text = films.movies!![position]!!.title +" - " + films.movies!![position]!!.voteAverage.toString()
        rate.text = "_________"
        descricao.text = films.movies!![position]!!.originalTitle.toString()
        imageFilm.loadUrl("https://image.tmdb.org/t/p/w500/"+films.movies!![position]!!.posterPath)
        relativeLayout.id = films.movies!![position]!!.id!!

        println("title: " + title.text + "rate: " + rate.text + "desc: " + descricao.text + "img: " + films.movies!![position]!!.posterPath
                + "id: " + relativeLayout.id)

    }

    init {
        this.rate = view.findViewById(R.id.tvRate) as TextView
        this.imageFilm = view.findViewById(R.id.ImageFilm) as ImageView
        this.title = view.findViewById(R.id.tvTitulo) as TextView
        this.descricao = view.findViewById(R.id.tvDescricao) as TextView
        relativeLayout = view.findViewById(R.id.relativeCard) as LinearLayout

        relativeLayout.setOnClickListener {
            val id = relativeLayout.id

            val intent = Intent(context!!,ActivityDetalhes::class.java)
            bundle!!.putInt("id_movie",id)
            intent!!.putExtras(bundle)
            context.startActivity(intent)

        }

    }
}