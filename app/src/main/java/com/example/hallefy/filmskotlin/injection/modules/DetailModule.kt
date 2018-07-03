package com.example.hallefy.filmskotlin.injection.modules

import com.example.hallefy.filmskotlin.views.moviedetail.ActivityDetalhes
import com.example.hallefy.filmskotlin.views.moviedetail.DetailInteractor
import com.example.hallefy.filmskotlin.views.moviedetail.DetailMVP
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DetailModule(var activityDetalhes: ActivityDetalhes){

    @Singleton
    @Provides
    fun provideDetailView() : DetailMVP.View{
        return activityDetalhes
    }

    @Singleton
    @Provides
    fun provideInteractor() : DetailMVP.Interactor {
        return DetailInteractor()
    }
}