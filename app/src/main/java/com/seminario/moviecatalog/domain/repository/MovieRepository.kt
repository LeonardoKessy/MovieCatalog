package com.seminario.moviecatalog.domain.repository

import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.model.MovieDetail

interface MovieRepository {

    suspend fun getPopularMovies() : List<Movie>

    suspend fun getMovie(id : Int) : MovieDetail

    suspend fun getSimilarMovies(id: Int) : List<Movie>

    suspend fun getMoviesByQuery(query: String) : List<Movie>
}