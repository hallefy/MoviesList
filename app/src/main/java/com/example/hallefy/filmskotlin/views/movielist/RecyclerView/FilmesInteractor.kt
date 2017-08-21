package com.example.hallefy.filmskotlin.views.movielist.RecyclerView

import com.example.hallefy.filmskotlin.NetworkAPI.SearchRepositoryProvider
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by hallefy on 18/08/17.
 */



class FilmesInteractor () : FilmsMVP.Interactor {

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