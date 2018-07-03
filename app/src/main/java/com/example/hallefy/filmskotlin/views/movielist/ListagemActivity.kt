package com.example.hallefy.filmskotlin.views.movielist

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.injection.DaggerListComponent
import com.example.hallefy.filmskotlin.injection.ListComponent
import com.example.hallefy.filmskotlin.injection.modules.MoviesModule
import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.utils.gone
import com.example.hallefy.filmskotlin.utils.isVisible
import com.example.hallefy.filmskotlin.utils.visible
import com.example.hallefy.filmskotlin.views.movielist.adapter.ListagemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ListagemActivity : AppCompatActivity(), ListagemMVP.View {

    lateinit var moviesComponent : ListComponent
    @Inject lateinit var presenter : ListagemPresenter
    private var adapter : ListagemAdapter? = null
    var pageNum : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesComponent = DaggerListComponent
                .builder()
                .moviesModule(MoviesModule(this))
                .build()
        moviesComponent.inject(this)

        setUp()
    }

    fun setUp() {
        initRecycler()
        request()
    }

    fun request() {
        when (verifyConnection()) {
            true -> presenter.requestFilms(pageNum)
            false -> showErrorConnection()
        }
    }

    override fun showProgressBar() {
        progressBar.visible()
    }

    override fun hideProgressBar() {
        if(progressBar.isVisible()){
            progressBar.gone()
        }
    }

    fun initRecycler() {
        recycler_view.apply {
            setHasFixedSize(true)
            val linearLayout = GridLayoutManager(context, 2)
            layoutManager = linearLayout
        }
    }

    override fun addMovies(movie: List<Movie>) {
        if(adapter != null){
            adapter?.addMovie(movie)
        }else {
            adapter = ListagemAdapter(this, movie)
            recycler_view.adapter = adapter
        }
        pageNum++
    }

    override fun showErrorConnection() {
        AlertDialog.Builder(this).setTitle(getString(R.string.title_conection))
                .setMessage(getString(R.string.msg_conection))
                .setNeutralButton(R.string.btn_ok, { _, _ -> this.finish() })
                .show()
    }

    override fun hideDialog() {
        if(progressBar!!.isShown){
            progressBar?.visibility = View.GONE
        }
    }

    override fun verifyConnection(): Boolean {
            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
    }
}
