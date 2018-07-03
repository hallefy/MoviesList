package com.example.hallefy.filmskotlin.network

import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.network.models.MoviesResponse
import com.example.hallefy.filmskotlin.utils.Constants
import io.reactivex.Observable

class SearchRepository(val apiService: ApiService) {

    fun searchFilms(page_num : Int): Observable<MoviesResponse> {
        return apiService.getMovies(Constants.API_KEY, Constants.LANGUAGE, page_num.toString())
    }

    fun getMovieDetail(id : Int): Observable<Movie>{
        return apiService.getMovieDetail(id, Constants.API_KEY, Constants.LANGUAGE)
    }
}