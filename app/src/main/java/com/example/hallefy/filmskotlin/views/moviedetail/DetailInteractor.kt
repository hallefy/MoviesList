package com.example.hallefy.filmskotlin.views.moviedetail

import com.example.hallefy.filmskotlin.network.SearchRepositoryProvider
import com.example.hallefy.filmskotlin.network.models.Movie
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailInteractor : DetailMVP.Interactor{

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getMovieDetail(id_movie: Int, observer: Observer<Movie>) {
        val repository = SearchRepositoryProvider.provideSearchRepository()

        compositeDisposable.add(
                repository.getMovieDetail(id_movie)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            response -> observer.onNext(response)
                        }, { error ->
                            observer.onError(error)
                        })
        )
    }

    override fun cancelRequest() {
        compositeDisposable.clear()
    }
}