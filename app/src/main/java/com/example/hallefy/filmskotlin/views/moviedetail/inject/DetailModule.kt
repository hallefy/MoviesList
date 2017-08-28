package com.example.hallefy.filmskotlin.views.moviedetail.inject

import android.app.Activity
import android.app.AlertDialog
import com.example.hallefy.filmskotlin.views.moviedetail.DetailInteractor
import com.example.hallefy.filmskotlin.views.moviedetail.DetailMVP
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by hallefy on 28/08/17.
 */
@Module
class DetailModule(val activity: Activity,val view : DetailMVP.View){

    @Singleton
    @Provides
    fun provideDetailView() : DetailMVP.View{
        return view
    }

    @Singleton
    @Provides
    fun provideActivity() : Activity{
        return activity
    }

    @Singleton
    @Provides
    fun provideInteractor() : DetailMVP.Interactor {
        return DetailInteractor()
    }


    @Singleton
    @Provides
    fun provideAlertDialog() : AlertDialog.Builder{
        return AlertDialog.Builder(activity)
    }

}