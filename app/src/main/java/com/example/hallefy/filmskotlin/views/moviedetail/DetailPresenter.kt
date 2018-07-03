package com.example.hallefy.filmskotlin.views.moviedetail

import com.example.hallefy.filmskotlin.network.models.Movie
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val interactor: DetailMVP.Interactor,
                                          private val view: DetailMVP.View) :
        DetailMVP.Presenter, Observer<Movie>{

    override fun onNext(response : Movie) {
        view.hideProgressBar()
        view.showConteudoLayout()
        view.bind(response)
    }

    override fun onSubscribe(d: Disposable?) {}

    override fun onComplete() {
    }

    override fun onError(e: Throwable?) {
        when (e) {
            is HttpException -> {
                view.showErrorConnection("Erro ao tentar obter detalhes do filme")
            }
            is UnknownHostException -> {
                view.showErrorConnection("Sem conexão com a internet")
            }
        }
    }

    override fun requestDetail(id_movie : Int) {
        view.showProgressBar()
        interactor.getMovieDetail(id_movie, this)
    }
}