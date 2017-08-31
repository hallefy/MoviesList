package com.example.hallefy.filmskotlin.views.movielist.movielist

import android.content.Context
import android.content.DialogInterface
import android.graphics.Rect
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.FilmsMVP
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.FilmsPresenter
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.injection.DaggerMoviesComponent
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.injection.MoviesComponent
import com.example.hallefy.filmskotlin.views.movielist.RecyclerView.injection.MoviesModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ListagemActivity : AppCompatActivity(), FilmsMVP.View {

    @Inject lateinit var mFilmsPresenter : FilmsPresenter
    private var moviesComponent : MoviesComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.apply {
            setHasFixedSize(true)
            val linearLayout = GridLayoutManager(context, 2)
            layoutManager = linearLayout
            recycler_view.addItemDecoration(SpacesItemDecoration(resources.getDimensionPixelSize(R.dimen.default_padding)))
        }

        moviesComponent = DaggerMoviesComponent
                .builder()
                .moviesModule(MoviesModule(this,this,recycler_view))
                .build()
        moviesComponent!!.inject(this)

        var presenter = FilmsPresenter(recycler_view, moviesComponent!!.provideAdapterMovies(),this)

        if(verifyConnection()){
            //if internet connection is ok
            presenter.requestFilms()
        }else{
            //if not have internet connection
            showErrorConnection()
        }
    }

    override fun showErrorConnection() {
        AlertDialog.Builder(this).setTitle("Sem conexão com a internet")
                .setMessage("Por favor checar sua conexão e tentar novamente!")
                .setNeutralButton(R.string.btn_ok, DialogInterface.OnClickListener { dialog, which -> this.finish() })
                .setIcon(android.R.drawable.ic_dialog_alert).show()

    }

    override fun showMoreFilms() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideDialog() {
        if(progressBar!!.isShown){
            progressBar?.visibility = View.GONE
        }
    }

    override fun getMoviesRecyclerView(): RecyclerView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun requestMovies(){

    }

    internal inner class SpacesItemDecoration(space: Int) : RecyclerView.ItemDecoration() {

        private val halfSpace: Int = space / 2

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {

            if (parent.paddingLeft != halfSpace) {
                parent.setPadding(halfSpace, halfSpace, halfSpace, halfSpace)
                parent.clipToPadding = false
            }

            outRect.top = halfSpace
            outRect.bottom = halfSpace
            outRect.left = halfSpace
            outRect.right = halfSpace
        }
    }

    override fun verifyConnection(): Boolean {
            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager// 1
            val networkInfo = connectivityManager.activeNetworkInfo // 2
            return networkInfo != null && networkInfo.isConnected // 3
    }
}
