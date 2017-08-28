package com.example.hallefy.filmskotlin.views.movielist.RecyclerView.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse

import com.example.hallefy.filmskotlin.R
import com.example.hallefy.filmskotlin.views.movielist.utils.LoadMoreListener

/**
 * Created by hallefy on 17/08/17.
 */

class MyRecyclerAdapter(private val mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private val visibleThreshold = 3
    private var lastVisibleItem : Int = 0
    private var feedItemList: List<Movie?>? = null
    private var totalItemCount: Int = 0
    private var loading: Boolean = false
    private var response : MoviesResponse? = null
    private var onLoadMoreListener: LoadMoreListener? = null


    private val VIEW_MOVIE = 1
    private val VIEW_LOADING = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        if(viewType == VIEW_MOVIE){
            val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_row_films, viewGroup,false)

            return RecyclerHolder(v, mContext, response!!)
        }else if (viewType == VIEW_LOADING){
            val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_main, viewGroup, false)
            val progressBar = v.findViewById(R.id.progressBar) as ProgressBar
            return LoadingViewHolder(v, progressBar)
        }
        return null
    }

    override fun getItemCount(): Int {
        return feedItemList!!.size
    }


    override fun getItemViewType(position: Int): Int {

        if (feedItemList!![position] == null) {
            return VIEW_LOADING
        } else {
            return VIEW_MOVIE
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, i: Int) {


        if(holder.itemViewType == VIEW_MOVIE){
            val holderMovies = holder as RecyclerHolder
            holderMovies.bind(response!!, i)
        } else if (holder.itemViewType == VIEW_LOADING) {
            val holderLoading = holder as LoadingViewHolder
            holderLoading.bind()
        }else{
            val holderLoading = holder as LoadingViewHolder
            holderLoading.unBind()
        }

    }

    fun swap(datas: java.util.ArrayList<Movie?>?) {
        Log.d("Swap: ", "datas: " + datas!!.size)
        response?.movies?.removeAt(response!!.movies!!.size- 1)
        notifyItemRemoved(response!!.movies!!.size - 1)
        if(datas != null){
            response!!.movies!!.addAll(datas)
        }

        notifyItemInserted(response!!.movies!!.size)
        setLoaded()
    }

    fun setLoaded() {
        loading = false
    }

    fun setValuesAdapter(list: ArrayList<Movie?>?, response: MoviesResponse)
    {
        this.feedItemList = list
        this.response = response
    }

    fun setRecyclerViewListener(recyclerView: RecyclerView) : Unit{
        if(recyclerView.layoutManager is LinearLayoutManager){
            val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager

            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrolled(recyclerview: RecyclerView?, dx: Int, dy: Int) {

                    super.onScrolled(recyclerView, dx, dy)
                    totalItemCount = linearLayoutManager.itemCount
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()

                    if (!loading && totalItemCount <= lastVisibleItem + visibleThreshold) {
                        Log.i("OnLoadMoreListener", "requisitando mais itens")
                        if(onLoadMoreListener != null){

                            onLoadMoreListener?.onLoadMore(response!!)

                        }

                        loading = true
                    }
                }
            })
        }
    }


    fun setOnLoadMoreListener(onLoadMoreListener: LoadMoreListener){
        this.onLoadMoreListener = onLoadMoreListener
    }

}
