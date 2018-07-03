package com.example.hallefy.filmskotlin.injection

import com.example.hallefy.filmskotlin.injection.modules.MoviesModule
import com.example.hallefy.filmskotlin.views.movielist.ListagemActivity
import dagger.Component
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Singleton
@Component(
        modules = [MoviesModule::class]
)

interface ListComponent{
    fun inject(@NotNull listagemActivity: ListagemActivity)
}