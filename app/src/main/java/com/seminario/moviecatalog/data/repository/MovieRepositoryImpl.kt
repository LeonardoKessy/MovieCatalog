package com.seminario.moviecatalog.data.repository

import com.seminario.moviecatalog.data.remote.api.TmdbApi
import com.seminario.moviecatalog.data.remote.dto.toDomain
import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TmdbApi
) : MovieRepository {

    override suspend fun getPopularMovies() : List<Movie> {
        val response = api.getPopularMovies()

        return response.results.map { it.toDomain() } ?: emptyList()
    }

}