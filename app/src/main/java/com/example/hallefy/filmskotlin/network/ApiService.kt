package com.example.hallefy.filmskotlin.network

import com.example.hallefy.filmskotlin.network.models.Movie
import com.example.hallefy.filmskotlin.network.models.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService{

    @retrofit2.http.GET("discover/movie?api_key=")
    fun getMovies(@Query("api_key") apiKey: String,
                  @Query("language") language: String,
                  @Query("page") page: String)
            : Observable<MoviesResponse>


    @GET("movie/{id}")
    fun getMovieDetail(@Path("id") id : Int,
                       @Query("api_key") apiKey: String ,
                       @Query("language") language : String)
            : Observable<Movie>


    companion object Factory {
        fun create(): ApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("http://api.themoviedb.org/3/")
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }


}