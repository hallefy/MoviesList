package com.example.hallefy.filmskotlin.views.movielist.movielist.pageobjects

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.movielist.adapter.ListagemViewHolder

object ListagemPageObject {

    fun clickOnCardView() {
        onView(withId(R.id.recycler_view)).
                perform(RecyclerViewActions.scrollToPosition<ListagemViewHolder>(15))
    }

    fun scrollToEnd() {
        onView(withId(R.id.recycler_view)).
                perform(ViewActions.swipeUp())
    }

    fun scrollToTop() {
        onView(withId(R.id.recycler_view)).
                perform(ViewActions.swipeDown())
    }
}