package com.example.hallefy.filmskotlin.views.movielist

import android.support.v7.widget.RecyclerView
import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.network.models.MoviesResponse
import io.reactivex.Observer

interface ListagemMVP{

    interface Interactor{
        fun requestDados(page_num: Int, observer: Observer<MoviesResponse>)
        fun cancelRequest()
    }

    interface Presenter{
        fun requestFilms()
        fun scrollListener(recyclerView: RecyclerView)
    }

    interface View {
        fun verifyConnection() : Boolean
        fun hideDialog()
        fun showErrorConnection()
        fun addMovies(movie: ArrayList<Movie>)
        fun showProgressBar()
        fun hideProgressBar()
        fun request()
        fun progressBarStatus(): Boolean
    }
}