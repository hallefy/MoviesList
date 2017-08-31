package com.example.hallefy.filmskotlin.movieListTest

import android.app.Activity
import android.support.v7.widget.RecyclerView
import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.FilmsMVP
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.FilmsPresenter
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter.MyRecyclerAdapter
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import java.lang.Exception
import java.util.ArrayList

/**
 * Created by hallefy on 31/08/17.
 */

@RunWith(MockitoJUnitRunner::class)
class PresenterTest {

    var recyclerView = mock<RecyclerView>()
    val activity = mock<Activity>()
    val view = mock<FilmsMVP.View>()
    var adapter = MyRecyclerAdapter(activity)
    val presenterMock = FilmsPresenter(recyclerView,adapter,view)

    @Test
    fun requestMovies() {
        presenterMock.requestFilms()
    }

    @Test
    fun testOnNext() {

        val movieResponse = MoviesResponse()
        val feedItem : ArrayList<Movie?>? = ArrayList()

        //cria lista fake
        val movies = Movie("teste","teste","data",1,"titulo","titulobr",
                "backdropPath",9.9)
        feedItem?.add(movies)
        movieResponse.movies = feedItem

        val r : Response<MoviesResponse> = Response.success(movieResponse)
        presenterMock.onNext(r.body())
    }

    @Test
    fun testAdapter() {
        presenterMock.initAdapter()
    }

    @Test
    fun testOnError() {
        presenterMock.onError(Exception::class.objectInstance)
    }
}