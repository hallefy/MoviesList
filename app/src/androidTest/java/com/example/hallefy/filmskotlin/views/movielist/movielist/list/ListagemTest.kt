package com.example.hallefy.filmskotlin.views.movielist.movielist.list

import android.support.test.espresso.intent.Intents
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.hallefy.filmskotlin.views.movielist.ListagemActivity
import com.example.hallefy.filmskotlin.views.movielist.movielist.pageobjects.ListagemPageObject
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListagemTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<ListagemActivity>(ListagemActivity::class.java, false, true)
    val pageObjectListagem = ListagemPageObject
    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testClickOnCardView() {
        pageObjectListagem.clickOnCardView()
    }

    @Test
    fun testScrollRecyclerView() {
        pageObjectListagem.scrollToEnd()
        pageObjectListagem.scrollToTop()
        pageObjectListagem.scrollToEnd()
        pageObjectListagem.scrollToTop()
    }
}