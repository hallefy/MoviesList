package com.example.hallefy.filmskotlin.views.movielist.movielist.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.example.hallefy.filmskotlin.R

object DetalhesPageObject {

    fun messageConnectionIsVisible() {
        onView(withId(R.id.tvMessageConnection)).check(matches(isDisplayed()))
    }

    fun imageErrorConnectionIsVisible() {
        onView(withId(R.id.ivConnection)).check(matches(isDisplayed()))
    }

    fun layoutConteudoIsVisible() {
        onView(withId(R.id.layoutConteudo)).check(matches(isDisplayed()))
    }

    fun bannerIsVisible() {
        onView(withId(R.id.ivBanner)).check(matches(isDisplayed()))
    }

    fun descriptionIsVisible() {
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
    }

    fun releaseIsVisible() {
        onView(withId(R.id.tvRelease)).check(matches(isDisplayed()))
    }
}