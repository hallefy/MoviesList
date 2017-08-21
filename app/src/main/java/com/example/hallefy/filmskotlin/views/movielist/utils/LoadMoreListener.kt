package com.example.hallefy.filmskotlin.views.movielist.utils

import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse

/**
 * Created by hallefy on 21/08/17.
 */

interface LoadMoreListener{
    fun onLoadMore(response : MoviesResponse)
}
