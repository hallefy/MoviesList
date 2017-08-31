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
            @SerializedName("id")
            var id: Int?,
            @SerializedName("original_title")
            var originalTitle: String?,
            @SerializedName("title")
            var title: String?,
            @SerializedName("backdrop_path")
            var backdropPath: String?,
            @SerializedName("vote_average")
            var voteAverage: Double?)



data class MoviesResponse (
        @SerializedName("results")
        var movies : ArrayList<Movie?>? = null
)

