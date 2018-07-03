package com.example.hallefy.filmskotlin.network

object SearchRepositoryProvider {

    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(ApiService.Factory.create())
    }
}