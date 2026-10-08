package com.seminario.moviecatalog.domain.repository

import com.seminario.moviecatalog.domain.model.Movie

interface MovieRepository {

    suspend fun getPopularMovies() : List<Movie>

}