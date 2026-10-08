package com.seminario.moviecatalog.data.remote.dto

import com.seminario.moviecatalog.data.remote.TmdbApi
import com.seminario.moviecatalog.domain.model.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatalogListDto(
    @SerialName("page")
    val page: Int,

    @SerialName("results")
    val results: List<CatalogMovieDto>,

    @SerialName("total_pages")
    val totalPages: Int,

    @SerialName("total_results")
    val totalResults: Int
)


@Serializable
data class CatalogMovieDto(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("overview")
    val overview: String,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("vote_average")
    val rating: Double
)

fun CatalogMovieDto.toDomain() : Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        posterPath =  "${TmdbApi.IMAGE_BASE_URL}${this.posterPath}",
        rating = this.rating
    )
}