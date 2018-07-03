package com.example.hallefy.filmskotlin.injection.modules

import com.example.hallefy.filmskotlin.views.movielist.ListagemInteractor
import com.example.hallefy.filmskotlin.views.movielist.ListagemMVP
import com.example.hallefy.filmskotlin.views.movielist.ListagemPresenter
import com.example.hallefy.filmskotlin.views.movielist.ListagemActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesModule(var listagemActivity: ListagemActivity){

    @Singleton
    @Provides
    fun providesListagemActivity() : ListagemMVP.View {
        return listagemActivity
    }

    @Singleton
    @Provides
    fun providesInteractor() : ListagemMVP.Interactor {
        return ListagemInteractor()
    }

    @Singleton
    @Provides
    fun providesPresenter(listatemView : ListagemMVP.View, interactor: ListagemMVP.Interactor) : ListagemMVP.Presenter{
        return ListagemPresenter(listatemView, interactor)
    }
}