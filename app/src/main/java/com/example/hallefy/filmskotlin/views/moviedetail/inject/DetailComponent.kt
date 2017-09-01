package com.example.hallefy.filmskotlin.views.moviedetail.inject

import com.example.hallefy.filmskotlin.views.moviedetail.ActivityDetalhes
import dagger.Component
import javax.inject.Singleton

/**
 * Created by hallefy on 28/08/17.
 */

@Singleton
@Component(
        modules = arrayOf(DetailModule::class)
)

interface DetailComponent {
    fun inject(activity: ActivityDetalhes)
}