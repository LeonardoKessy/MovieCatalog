package com.seminario.moviecatalog.data.repository

import com.seminario.moviecatalog.data.remote.api.TmdbApi
import com.seminario.moviecatalog.data.remote.dto.CatalogListDto
import com.seminario.moviecatalog.data.remote.dto.CatalogMovieDto
import com.seminario.moviecatalog.data.remote.dto.MovieDetailDto
import com.seminario.moviecatalog.data.remote.dto.toDomain
import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.model.MovieDetail
import com.seminario.moviecatalog.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TmdbApi
) : MovieRepository {

    override suspend fun getPopularMovies() : List<Movie> {
        val response : CatalogListDto = api.getPopularMovies()

        return response.results.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun getMovie(id : Int) : MovieDetail {
        val response : MovieDetailDto = api.getMovieDetails(movieId = id)

        return response.toDomain()
    }

    override suspend fun getSimilarMovies(id: Int): List<Movie> {
        val response : CatalogListDto = api.getSimilarMovies(movieId = id)

        return response.results.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun getMoviesByQuery(query: String): List<Movie> {
       val response : CatalogListDto = api.searchMovies(query = query)

       return response.results.map { it.toDomain() }
    }
}