package com.example.hallefy.filmskotlin.views.movielist.movielist

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId


fun isVisible(id : Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun sleep(seconds : Long) {
    Thread.sleep(seconds * 1000)
}