package com.example.hallefy.filmskotlin.NetworkAPI.models

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Created by hallefy on 16/08/17.
 */


data class Films(

        @SerializedName("title")
        val title : String? = null,

        @SerializedName("overview")
        val description : String? = null,

        @SerializedName("vote_average")
        val rate : String? = null,

        @SerializedName("backdrop_path")
        val thumbnail : String? = null
)

class Movie(@SerializedName("poster_path")
            var posterPath: String?, @SerializedName("adult")
            var isAdult: Boolean, @SerializedName("overview")
            var overview: String?, @SerializedName("release_date")
            var releaseDate: String?, genreIds: List<Int>, @SerializedName("id")
            var id: Int?,
            @SerializedName("original_title")
            var originalTitle: String?, @SerializedName("original_language")
            var originalLanguage: String?, @SerializedName("title")
            var title: String?, @SerializedName("backdrop_path")
            var backdropPath: String?, @SerializedName("popularity")
            var popularity: Double?,
            @SerializedName("vote_count")
            var voteCount: Int?, @SerializedName("video")
            var video: Boolean?, @SerializedName("vote_average")
            var voteAverage: Double?) {
        @SerializedName("genre_ids")
        var genreIds: List<Int> = ArrayList()

        init {
                this.genreIds = genreIds
        }
}

class Response {
        @SerializedName("page")
        var page: Int = 0
        @SerializedName("results")
        var results: List<Movie>? = null
        @SerializedName("total_results")
        var totalResults: Int = 0
        @SerializedName("total_pages")
        var totalPages: Int = 0

        data class Result(val total_count: Int, val items: List<Movie>)

}


data class MoviesResponse (
        @SerializedName("results")
        var movies : ArrayList<Movie?>? = null
)

