package com.example.hallefy.filmskotlin.views.moviedetail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.moviedetail.inject.DaggerDetailComponent
import com.example.hallefy.filmskotlin.views.moviedetail.inject.DetailModule
import javax.inject.Inject

class ActivityDetalhes : AppCompatActivity(), DetailMVP.View {

    @Inject
    lateinit var presenter : DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        DaggerDetailComponent.builder()
                .detailModule(DetailModule(this,this))
                .build()
                .inject(this)

        presenter.requestDetail(getReceivedData())
    }

    override fun getReceivedData(): Int {
        var intent : Intent? = intent
        var bundle : Bundle?

        bundle = intent!!.extras
        val id = bundle!!.getInt("id_movie")

        return id
    }

}
