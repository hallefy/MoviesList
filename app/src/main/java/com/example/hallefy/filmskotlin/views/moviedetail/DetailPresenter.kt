package com.example.hallefy.filmskotlin.views.moviedetail

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.utils.Constants
import com.example.hallefy.filmskotlin.utils.loadUrl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by hallefy on 28/08/17.
 */
class DetailPresenter @Inject constructor(private val interactor: DetailMVP.Interactor,
                                          private val activity: Activity): DetailMVP.Presenter,Observer<Movie>{

    var description : TextView? = null
    var imageFilm : ImageView? = null
    var release : TextView? = null
    var progressBar : ProgressBar? = null

    @SuppressLint("SetTextI18n")
    override fun onNext(response : Movie?) {
        progressBar!!.visibility = View.GONE

        description!!.text = "Description: ${response?.overview}"
        imageFilm!!.loadUrl(Constants.IMG_URL + response?.backdropPath)
        release!!.text = "Release data: ${response?.releaseDate}"
    }

    override fun onSubscribe(d: Disposable?) {}

    override fun onComplete() {
    }

    override fun onError(e: Throwable?) {
    }

    override fun requestDetail(id_movie : Int) {
        initComponents()

        progressBar!!.visibility = View.VISIBLE
        progressBar!!.requestFocus()

        interactor.getMovieDetail(id_movie, this)
    }

    fun initComponents(){

        release = activity.findViewById(R.id.tvRelease) as TextView
        description = activity.findViewById(R.id.tvDescriptionFilm) as TextView
        imageFilm = activity.findViewById(R.id.imgBannerFilm) as ImageView
        progressBar = activity.findViewById(R.id.progressBarDetail) as ProgressBar

    }
}