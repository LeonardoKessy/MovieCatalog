package com.seminario.moviecatalog.data.remote.api

import com.seminario.moviecatalog.data.remote.dto.CatalogListDto
import com.seminario.moviecatalog.data.remote.dto.MovieDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies() : CatalogListDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ) : MovieDetailDto

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int
    ) : CatalogListDto

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String
    ) : CatalogListDto
}