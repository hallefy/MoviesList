package com.example.hallefy.filmskotlin.views.movielist.movielist.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.movielist.movielist.isVisible

object DetalhesPageObject {

    fun messageConnectionIsVisible() {
        isVisible(R.id.tvMessageConnection)
    }

    fun imageErrorConnectionIsVisible() {
        isVisible(R.id.ivConnection)
    }

    fun layoutConteudoIsVisible() {
        isVisible(R.id.layoutConteudo)
    }

    fun bannerIsVisible() {
        isVisible(R.id.ivBanner)
    }

    fun descriptionIsVisible() {
        isVisible(R.id.tvDescription)
    }

    fun releaseIsVisible() {
        isVisible(R.id.tvRelease)
    }
}