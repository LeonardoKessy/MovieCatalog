package com.seminario.moviecatalog.ui.mock

import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.model.MovieDetail

object MockData {

    val movieDetail : MovieDetail = MovieDetail(
        id = 1291595,
        title = "Insidious: Out of the Further",
        overview = "Gemma, a young mother raising her daughter in the house she grew up in, discovers she can travel into The Further, the purgatorial realm of lost souls at the heart of the Insidious universe. When something evil comes after her, Gemma discovers an ability that changes everything: she doesn't just enter The Further, she can bring what lives there back to the real world. Once the demons realize her power, our world becomes their playground.",
        backdropPath = "https://image.tmdb.org/t/p/w500/p40lmrdI4blcAPZQMTPaiy5v5Ym.jpg",
        rating = 7.7,
        releaseDate = "2026-08-19",
        genres = listOf("Horror", "Thriller"),
        producers = listOf("Screen Gems", "Stage 6 Films", "Atomic Monster", "TSG Entertainment", "Oren Peli Productions", "Blumhouse Atomic Monster")
    )

    val singleMovie = Movie(
        id = 1423191,
        title = "Resident Evil",
        posterPath = "https://image.tmdb.org/t/p/w500//i7UyjfPio0VFHB9rBUZSFyhOoM8.jpg",
        rating = 7.316
    )

    val movies = listOf(
        Movie(
            id = 1423191,
            title = "Resident Evil",
            posterPath = "https://image.tmdb.org/t/p/w500//i7UyjfPio0VFHB9rBUZSFyhOoM8.jpg",
            rating = 7.316
        ),
        Movie(
            id = 969681,
            title = "Spider-Man: Brand New Day",
            posterPath = "https://image.tmdb.org/t/p/w500//bjiS5ipwxb9JFy3XRRN4OAilSeX.jpg",
            rating = 8.308
        ),
        Movie(
            id = 1368337,
            title = "The Odyssey",
            posterPath = "https://image.tmdb.org/t/p/w500//5rhTDKUhPYvpdQIijFIs5VoWsON.jpg",
            rating = 8.014
        ),
        Movie(
            id = 1291595,
            title = "Insidious: Out of the Further",
            posterPath = "https://image.tmdb.org/t/p/w500//4tTrW9dXCByS5wt2pXVWb58zNjz.jpg",
            rating = 7.548
        ),
        Movie(
            id = 1228834,
            title = "The Fix",
            posterPath = "https://image.tmdb.org/t/p/w500//yopXjun3ICFfJci2ukcEzceZjUs.jpg",
            rating = 6.76
        )
    )

    val emptyMovies = emptyList<Movie>()
}