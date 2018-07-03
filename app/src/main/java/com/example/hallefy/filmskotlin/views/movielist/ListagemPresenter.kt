package com.example.hallefy.filmskotlin.views.movielist

import com.example.hallefy.filmskotlin.network.models.MoviesResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ListagemPresenter @Inject constructor(private val view : ListagemMVP.View,
                                            var interactor: ListagemMVP.Interactor):
        ListagemMVP.Presenter, Observer<MoviesResponse> {

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable?) {
    }

    override fun onNext(response: MoviesResponse) {
        view.hideProgressBar()
        view.addMovies(response.movies)
    }

    override fun requestFilms(pageNum : Int) {
        view.showProgressBar()
        interactor.requestDados(pageNum,this)
    }

    override fun onError(e: Throwable?) {
        view.hideProgressBar()
        error("500")
    }

    fun error(errorType : String) {
        if(errorType == "500"){
            view.showErrorConnection()
        }
    }

    private fun loadMoreList() {

    }
}