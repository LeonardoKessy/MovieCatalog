package com.seminario.moviecatalog.domain.model

data class Movie (
    val id : Int,
    val title : String,
    val overview : String,
    val posterPath : String,
    val rating : Double,
)


