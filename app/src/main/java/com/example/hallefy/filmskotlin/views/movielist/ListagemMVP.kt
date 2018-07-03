package com.example.hallefy.filmskotlin.views.movielist

import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.network.models.MoviesResponse
import io.reactivex.Observer

interface ListagemMVP{

    interface Interactor{
        fun requestDados(page_num: Int, observer: Observer<MoviesResponse>)
        fun cancelRequest()
    }

    interface Presenter{
        fun requestFilms(pageNum : Int)
    }

    interface View {
        fun verifyConnection() : Boolean
        fun hideDialog()
        fun showErrorConnection()
        fun addMovies(movie: List<Movie>)
        fun showProgressBar()
        fun hideProgressBar()
    }
}