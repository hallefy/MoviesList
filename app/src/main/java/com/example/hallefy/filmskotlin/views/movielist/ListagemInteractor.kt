package com.example.hallefy.filmskotlin.views.movielist

import com.example.hallefy.filmskotlin.network.SearchRepositoryProvider
import com.example.hallefy.filmskotlin.network.models.MoviesResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListagemInteractor : ListagemMVP.Interactor {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun requestDados(page_num: Int, observer: Observer<MoviesResponse>){
        val repository = SearchRepositoryProvider.provideSearchRepository()

        compositeDisposable.add(
                repository.searchFilms(page_num)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            response ->
                            observer.onNext(response)
                        }, { error ->
                            error.printStackTrace()
                        })
        )
    }

    override fun cancelRequest(){
        compositeDisposable.clear()
    }
}