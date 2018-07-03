package com.example.hallefy.filmskotlin.views.moviedetail

import com.example.hallefy.filmskotlin.network.models.Movie
import io.reactivex.Observer

interface DetailMVP {

    interface Interactor {
        fun getMovieDetail(id_movie: Int, observer: Observer<Movie>)
        fun cancelRequest()
    }


    interface Presenter {
        fun requestDetail(id_movie: Int)
    }

    interface View {
        fun hideProgressBar()
        fun showProgressBar()
        fun getReceivedData() : Int
        fun bind(movie: Movie)
        fun showErrorConnection(message : String)
        fun showConteudoLayout()
    }

}
