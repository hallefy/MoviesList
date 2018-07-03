package com.example.hallefy.filmskotlin.movieListTest

import com.example.hallefy.filmskotlin.views.movielist.ListagemMVP
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by hallefy on 31/08/17.
 */

@RunWith(MockitoJUnitRunner::class)
class MoviesViewTest{

    private val view = mock<ListagemMVP.View>()

    @Test
    fun testingConnection() {
        view.verifyConnection()
    }

    @Test
    fun testShowErrorConnection() {
        view.showErrorConnection()
    }
}