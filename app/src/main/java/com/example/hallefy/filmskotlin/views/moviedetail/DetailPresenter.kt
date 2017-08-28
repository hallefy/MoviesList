package com.example.hallefy.filmskotlin.views.moviedetail

import android.app.Activity
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.movielist.utils.loadUrl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_detalhes.*
import javax.inject.Inject

/**
 * Created by hallefy on 28/08/17.
 */
class DetailPresenter @Inject constructor(private val interactor: DetailMVP.Interactor,
                                          private val activity: Activity): DetailMVP.Presenter,Observer<Movie>{

    var description : TextView? = null
    var imageFilm : ImageView? = null

    override fun onNext(response : Movie?) {
        initComponents()
        println(response!!.overview)
        description!!.text = response!!.overview
        imageFilm!!.loadUrl("https://image.tmdb.org/t/p/w500/"+response!!.posterPath)
    }

    override fun onSubscribe(d: Disposable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        println("TESTE.OnSubscribe")
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        println("TESTE.onComplete")

    }

    override fun onError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun requestDetail(id_movie : Int) {
        var interactor = DetailInteractor()
        interactor.getMovieDetail(id_movie, this)
    }

    fun initComponents(){


        description = activity.findViewById(R.id.tvDescriptionFilm) as TextView
        imageFilm = activity.findViewById(R.id.imgBannerFilm) as ImageView
    }


}