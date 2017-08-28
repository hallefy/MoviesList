package com.example.hallefy.filmskotlin.views.movielist.RecyclerView

import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter.MyRecyclerAdapter
import com.example.hallefy.filmskotlin.views.movielist.utils.LoadMoreListener
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by hallefy on 18/08/17.
 */


class FilmsPresenter @Inject constructor(private val recyclerView: RecyclerView,
                                         private val adapter : MyRecyclerAdapter): FilmsMVP.Presenter, Observer<MoviesResponse> {

    var page_num :Int = 1
    private var totalMovies = 0
    private var ultimoLimit = 0


    override fun onNext(response: MoviesResponse?) {
        initAdapter()
        page_num++


        if(response != null){
            totalMovies = response.movies!!.size
            Log.d("totalMovies", totalMovies.toString())
        }

        Log.d("page", page_num.toString())

        if(response!!.movies!!.isNotEmpty()){
            ultimoLimit = 0

            if(page_num <= 2){



                adapter.setValuesAdapter(response.movies,response)
                adapter.setRecyclerViewListener(recyclerView)
                adapter.setLoaded()

                recyclerView.adapter = adapter

                //evento do scroll do recyclerView
                loadMoreList()

            }else{
                adapter.swap(response.movies)
            }
        }else{
            adapter.swap(response.movies)
        }

    }


    private fun initAdapter() {
        if (recyclerView.adapter == null){
            recyclerView.adapter = adapter
            adapter.setRecyclerViewListener(recyclerView)
        }
    }


    override fun requestFilms() {
        var interactor = FilmesInteractor()
        interactor.requestDados(page_num,this)
    }

    override fun onComplete() {
    }

    override fun onError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubscribe(d: Disposable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun loadMoreList(){

        Log.d("loadMoreList","entrou na funcao loadMoreList")

        adapter.setOnLoadMoreListener(object : LoadMoreListener{
            override fun onLoadMore(response: MoviesResponse) {
                if(ultimoLimit < totalMovies){
                    if(response.movies?.size!! >= 20){
                        ultimoLimit+=20

                        Log.d("ultimo limite: ", ultimoLimit.toString())

                        response.movies!!.add(null)
                        recyclerView.post{adapter.notifyItemInserted(ultimoLimit)}

                        requestFilms()
                    }
                }
            }

        })
    }

}