package com.example.hallefy.filmskotlin.views.movielist

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.hallefy.filmskotlin.network.models.MoviesResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ListagemPresenter @Inject constructor(private val view : ListagemMVP.View,
                                            var interactor: ListagemMVP.Interactor):
        ListagemMVP.Presenter, Observer<MoviesResponse> {

    private var pageNum : Int = 1

    override fun requestFilms() {
        view.showProgressBar()
        interactor.requestDados(pageNum,this)
    }

    override fun onError(e: Throwable?) {
        view.hideProgressBar()
        error("500")
    }

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable?) {
    }

    override fun onNext(response: MoviesResponse) {
        pageNum++
        view.hideProgressBar()
        view.addMovies(response.movies)
    }

    override fun scrollListener(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val linearLayout = recyclerView.layoutManager as LinearLayoutManager
                val totalItem = linearLayout.itemCount
                val lastItem = linearLayout.findLastVisibleItemPosition()

                if (!view.progressBarStatus() && totalItem <= lastItem + 3){
                    view.request()
                }
            }
        })
    }

    fun error(errorType : String) {
        if(errorType == "500"){
            view.showErrorConnection()
        }
    }
}