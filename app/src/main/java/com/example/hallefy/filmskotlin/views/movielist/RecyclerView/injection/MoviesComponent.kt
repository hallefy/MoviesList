package com.example.hallefy.filmskotlin.views.movielist.RecyclerView.injection

import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter.MyRecyclerAdapter
import com.example.hallefy.filmskotlin.views.movielist.movielist.ListagemActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by hallefy on 28/08/17.
 */
@Singleton
@Component(modules = arrayOf(MoviesModule::class))

interface MoviesComponent{

    fun inject(listagemActivity: ListagemActivity)
    fun provideAdapterMovies() : MyRecyclerAdapter

}