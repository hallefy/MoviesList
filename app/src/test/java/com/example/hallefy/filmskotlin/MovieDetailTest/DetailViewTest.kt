package com.example.hallefy.filmskotlin.MovieDetailTest

import com.example.hallefy.filmskotlin.views.moviedetail.DetailMVP
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by hallefy on 31/08/17.
 */


@RunWith(MockitoJUnitRunner::class)
class DetailViewTest{

    private val view = mock<DetailMVP.View>()

    @Test
    fun testReceiverDataIntent() {
        view.getReceivedData()
    }

}