package com.seminario.moviecatalog.data.remote.api

import com.seminario.moviecatalog.data.remote.dto.CatalogListDto
import retrofit2.http.GET

interface TmdbApi {

    @GET("movie/popular")
    suspend fun getPopularMovies() : CatalogListDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails() // TODO

}