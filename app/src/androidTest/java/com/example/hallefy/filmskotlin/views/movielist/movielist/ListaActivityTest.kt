package com.example.hallefy.filmskotlin.views.movielist.movielist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter.RecyclerHolder
import org.junit.*
import org.junit.runner.RunWith

/**
 * Created by hallefy on 01/09/17.
 */


@RunWith(AndroidJUnit4::class)
class ListaActivityTest{

    private var mInstrumentationContext: Context? = null
    private var mAppContext: Context? = null
    private var mActivity: Activity? = null

    @Rule @JvmField
    var activityRule = ActivityTestRule<ListagemActivity>(ListagemActivity::class.java)

    @Before
    fun setUp() {
        mInstrumentationContext = InstrumentationRegistry.getContext()
        mAppContext = InstrumentationRegistry.getTargetContext()
        mActivity = activityRule.launchActivity(Intent())
    }

    @After
    @Throws(Exception::class)
    fun onFinish() {
        mActivity?.finish()
    }

    @Test
    fun testFocusOnActivity() {
        Assert.assertNotNull(mActivity)
    }

    @Test
    fun listScroll() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition<RecyclerHolder>(15))
    }
}