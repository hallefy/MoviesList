package com.example.hallefy.filmskotlin.views.movielist.RecyclerView

import android.support.v7.widget.RecyclerView
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import io.reactivex.Observer

/**
 * Created by hallefy on 18/08/17.
 */


interface FilmsMVP{

    interface Interactor{

        fun requestDados(page_num: Int, observer: Observer<MoviesResponse>)
        fun cancelRequest()

    }


    interface Presenter{
        fun requestFilms()
    }

    interface View{

        fun showMoreFilms()
        fun verifyConnection() : Boolean
        fun getMoviesRecyclerView() : RecyclerView
        fun hideDialog()
        fun showErrorConnection()
    }
}