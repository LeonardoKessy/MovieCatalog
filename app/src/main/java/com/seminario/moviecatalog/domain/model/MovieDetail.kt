package com.seminario.moviecatalog.domain.model

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val backdropPath: String,
    val rating: Double,
    val releaseDate: String,
    val genres: List<String>,
    val producers: List<String>
) {
}