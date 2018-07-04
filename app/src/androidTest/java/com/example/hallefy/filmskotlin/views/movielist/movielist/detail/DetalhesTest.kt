package com.example.hallefy.filmskotlin.views.movielist.movielist.detail

import android.support.test.espresso.intent.Intents
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.hallefy.filmskotlin.views.moviedetail.ActivityDetalhes
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.content.Intent
import com.example.hallefy.filmskotlin.views.movielist.movielist.pageobjects.DetalhesPageObject
import com.example.hallefy.filmskotlin.views.movielist.movielist.sleep


@RunWith(AndroidJUnit4::class)
class DetalhesTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<ActivityDetalhes>(ActivityDetalhes::class.java, false, false)
    val pageObjectDetalhe = DetalhesPageObject

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testViewElementsErrorConnectionIsVisible() {
        val intent = Intent()
        intent.putExtra("id_movie", -1)
        activityRule.launchActivity(intent)
        Intents.init()
        pageObjectDetalhe.imageErrorConnectionIsVisible()
        pageObjectDetalhe.messageConnectionIsVisible()
        sleep(2)
    }

    @Test
    fun testViewElementsIsVisible() {
        val intent = Intent()
        intent.putExtra("id_movie", 123)
        activityRule.launchActivity(intent)
        Intents.init()

        pageObjectDetalhe.layoutConteudoIsVisible()
        pageObjectDetalhe.bannerIsVisible()
        pageObjectDetalhe.descriptionIsVisible()
        pageObjectDetalhe.releaseIsVisible()
        sleep(2)
    }
}