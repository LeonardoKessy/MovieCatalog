package com.seminario.moviecatalog.data.remote.dto

import com.seminario.moviecatalog.data.remote.api.TmdbApiConstants
import com.seminario.moviecatalog.domain.model.MovieDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailDto(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("overview")
    val overview: String,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("runtime")
    val runtime: Int,

    @SerialName("vote_average")
    val rating: Double,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("genres")
    val genres: List<GenreDto>,

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>
)

@Serializable
data class GenreDto (
    @SerialName("name")
    val name: String
)

@Serializable
data class ProductionCompanyDto (
    @SerialName("name")
    val name: String
)


fun MovieDetailDto.toDomain() : MovieDetail {
    return MovieDetail(
        id = this.id,
        title = this.title,
        overview = this.overview,
        backdropPath = "${TmdbApiConstants.IMAGE_BASE_URL}${this.backdropPath}",
        rating = this.rating,
        releaseDate = this.releaseDate,
        genres = this.genres.map { it.name },
        producers = this.productionCompanies.map { it.name }
    );
}