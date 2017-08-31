package com.example.hallefy.filmskotlin.MovieDetailTest

import android.app.Activity
import com.example.hallefy.filmskotlin.views.moviedetail.DetailInteractor
import com.example.hallefy.filmskotlin.views.moviedetail.DetailPresenter
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.FilmsMVP
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by hallefy on 31/08/17.
 */


@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest{

    private val activity = mock<Activity>()
    private val interactor = DetailInteractor()

    private val presenter = DetailPresenter(interactor,activity)

    @Test
    fun testInitComponents() {
        presenter.initComponents()
    }

    @Test
    fun testRequestDetail() {

    }

    @Test
    fun testOnNext() {

    }

}