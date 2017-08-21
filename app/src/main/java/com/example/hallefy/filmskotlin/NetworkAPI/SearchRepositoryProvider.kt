package com.example.hallefy.filmskotlin.NetworkAPI

/**
 * Created by hallefy on 18/08/17.
 */

object SearchRepositoryProvider {

    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(ApiService.Factory.create())
    }

}