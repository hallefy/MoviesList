package com.example.hallefy.filmskotlin.NetworkAPI

import com.example.hallefy.filmskotlin.NetworkAPI.models.MoviesResponse
import com.example.hallefy.filmskotlin.NetworkAPI.models.Response

/**
 * Created by hallefy on 18/08/17.
 * classe responsável pelo requisicao a api
 */
class SearchRepository(val apiService: ApiService) {

    val API_KEY : String? = "362a511b0e7d3ed1216c24f338d8b490"
    val LANGUAGE : String? = "pt-BR"
    final val IMG_URL : String = "https://image.tmdb.org/t/p/w500/"

    fun searchFilms(page_num : Int): io.reactivex.Observable<MoviesResponse> {
        return apiService.getMovies(API_KEY!!, LANGUAGE!!, page_num.toString())
    }

}