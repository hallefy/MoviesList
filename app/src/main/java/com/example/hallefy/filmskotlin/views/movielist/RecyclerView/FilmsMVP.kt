package com.example.hallefy.filmskotlin.views.movielist.RecyclerView

import android.support.v7.widget.RecyclerView
import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import com.example.hallefy.filmskotlin.NetworkAPI.models.Response
import io.reactivex.Observer
import org.reactivestreams.Subscription

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

        fun showMoreFilms(movies : List<Movie>)
        fun verifyConnection() : Boolean
        fun getMoviesRecyclerView() : RecyclerView
    }
}