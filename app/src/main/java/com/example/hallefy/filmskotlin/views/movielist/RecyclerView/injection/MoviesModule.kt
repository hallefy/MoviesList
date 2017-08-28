package com.example.hallefy.filmskotlin.views.movielist.RecyclerView.injection

import android.app.Activity
import android.support.v7.widget.RecyclerView
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.FilmsMVP
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter.MyRecyclerAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hallefy on 21/08/17.
 */


@Module
class MoviesModule(private val activity: Activity,private val moviesView : FilmsMVP.View,private val recyclerView: RecyclerView){



    @Singleton
    @Provides
    fun provideAdapterMovie(): MyRecyclerAdapter{
        return MyRecyclerAdapter(activity)
    }

    @Singleton
    @Provides
    fun provideRecycler(): RecyclerView{
        return recyclerView
    }

    @Singleton
    @Provides
    fun provideMoviesView() : FilmsMVP.View{
        return moviesView;
    }

}