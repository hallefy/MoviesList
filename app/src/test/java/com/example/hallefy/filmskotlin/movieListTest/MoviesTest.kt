package com.example.hallefy.filmskotlin.movieListTest

import com.example.hallefy.filmskotlin.NetworkAPI.models.Movie
import org.junit.Assert
import org.junit.Before
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.ArrayList

/**
 * Created by hallefy on 31/08/17.
 */
@RunWith(MockitoJUnitRunner::class)
class MoviesTest {

    private var movies : Movie? = null

    companion object {
        private val ID_MOVIE = 2
        private val TITLE_MOVIE = "Homem de ferro"
        private val TITLE_ORIGINAL_MOVIE = "Iron man"
        private val POSTER_MOVIE = "imagem_filme"
        private val OVERVIEW_MOVIE = "Teste overview film"
        private val RELEASE_MOVIE = "10/12/2017"
        private val BACKDROP_MOVIE = "image_backdrop"
        private val VOTE_MOVIE = 8.8

        val feedItem  = ArrayList<Movie?>()
    }

    @Before
    fun setUp() {
        val list = Movie(POSTER_MOVIE, OVERVIEW_MOVIE, RELEASE_MOVIE, ID_MOVIE, TITLE_ORIGINAL_MOVIE, TITLE_MOVIE, BACKDROP_MOVIE, VOTE_MOVIE)

        feedItem.add(list)

        movies = Movie(POSTER_MOVIE, OVERVIEW_MOVIE, RELEASE_MOVIE, ID_MOVIE, TITLE_ORIGINAL_MOVIE, TITLE_MOVIE, BACKDROP_MOVIE, VOTE_MOVIE)
    }

    @Test
    fun testMovies() {
        Assert.assertThat(movies!!.id, `is`(ID_MOVIE))
        Assert.assertThat<String>(movies!!.title, `is`(TITLE_MOVIE))
        Assert.assertThat<String>(movies!!.originalTitle, `is`(TITLE_ORIGINAL_MOVIE))
        Assert.assertThat<String>(movies!!.posterPath, `is`(POSTER_MOVIE))
        Assert.assertThat<String>(movies!!.overview, `is`(OVERVIEW_MOVIE))
        Assert.assertThat<String>(movies!!.releaseDate, `is`(RELEASE_MOVIE))
        Assert.assertThat<String>(movies!!.backdropPath, `is`(BACKDROP_MOVIE))
        Assert.assertThat(movies!!.voteAverage, `is`(VOTE_MOVIE))
    }
}