package com.example.hallefy.filmskotlin.views.moviedetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.injection.DaggerDetailComponent
import com.example.hallefy.filmskotlin.injection.modules.DetailModule
import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.utils.Constants
import com.example.hallefy.filmskotlin.utils.gone
import com.example.hallefy.filmskotlin.utils.loadUrl
import com.example.hallefy.filmskotlin.utils.visible
import kotlinx.android.synthetic.main.activity_detalhes.*
import javax.inject.Inject

class ActivityDetalhes : AppCompatActivity(), DetailMVP.View {

    @Inject
    lateinit var presenter : DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        DaggerDetailComponent.builder()
                .detailModule(DetailModule(this))
                .build()
                .inject(this)

        presenter.requestDetail(getReceivedData())
    }

    override fun showErrorConnection(message : String) {
        progressBar.gone()
        layoutErrorConection.visible()
        layoutConteudo.gone()
        tvMessageConnection.text = message
    }

    override fun showConteudoLayout() {
        layoutConteudo.visible()
        layoutErrorConection.gone()
    }

    override fun hideProgressBar() {
        progressBar.gone()
    }

    override fun showProgressBar() {
        progressBar.visible()
    }

    override fun bind(movie : Movie) {
        ivBanner.loadUrl(Constants.IMG_URL+movie.backdropPath)
        tvDescription.text = movie.overview
        tvRelease.text = movie.releaseDate
        title = movie.title
    }

    override fun getReceivedData(): Int {
        val intent = intent
        val bundle = intent.extras

        return bundle.getInt("id_movie", 0)
    }
}
