package com.example.hallefy.filmskotlin.NetworkAPI.models

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Created by hallefy on 16/08/17.
 */

class Movie(@SerializedName("poster_path")
            var posterPath: String?,
            @SerializedName("overview")
            var overview: String?,
            @SerializedName("release_date")
            var releaseDate: String?,
            genreIds: List<Int>,
            @SerializedName("id")
            var id: Int?,
            @SerializedName("original_title")
            var originalTitle: String?,
            @SerializedName("title")
            var title: String?,
            @SerializedName("backdrop_path")
            var backdropPath: String?,
            @SerializedName("vote_average")
            var voteAverage: Double?) {
        @SerializedName("genre_ids")
        var genreIds: List<Int> = ArrayList()

        init {
                this.genreIds = genreIds
        }
}



data class MoviesResponse (
        @SerializedName("results")
        var movies : ArrayList<Movie?>? = null
)

