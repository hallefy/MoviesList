package com.example.hallefy.filmskotlin.injection

import com.example.hallefy.filmskotlin.injection.modules.DetailModule
import com.example.hallefy.filmskotlin.views.moviedetail.ActivityDetalhes
import dagger.Component
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton


@Singleton
@Component(
        modules = [DetailModule::class]
)

interface DetailComponent {
    fun inject(@NotNull activity: ActivityDetalhes)
}