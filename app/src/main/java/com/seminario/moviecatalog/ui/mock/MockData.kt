package com.seminario.moviecatalog.ui.mock

import com.seminario.moviecatalog.domain.model.Movie

object MockData {

    val singleMovie = Movie(
        id = 1423191,
        title = "Resident Evil",
        overview = "Medical courier Bryan unwittingly finds himself fighting for survival as one fateful, horrifying night collapses around him in chaos.",
        posterPath = "https://image.tmdb.org/t/p/w500//i7UyjfPio0VFHB9rBUZSFyhOoM8.jpg",
        rating = 7.316
    )

    val movies = listOf(
        Movie(
            id = 1423191,
            title = "Resident Evil",
            overview = "Medical courier Bryan unwittingly finds himself fighting for survival as one fateful, horrifying night collapses around him in chaos.",
            posterPath = "https://image.tmdb.org/t/p/w500//i7UyjfPio0VFHB9rBUZSFyhOoM8.jpg",
            rating = 7.316
        ),
        Movie(
            id = 969681,
            title = "Spider-Man: Brand New Day",
            overview = "Fighting crime full-time as Spider-Man in a world that doesn't remember him—and the pressure of seeing his old friends move on without him—sparks a change in Peter Parker he may not have the power to control. But that transformation might also be the only thing that can stop a shocking new threat to the city and those he loves - a powerful villain no one can even see.",
            posterPath = "https://image.tmdb.org/t/p/w500//bjiS5ipwxb9JFy3XRRN4OAilSeX.jpg",
            rating = 8.308
        ),
        Movie(
            id = 1368337,
            title = "The Odyssey",
            overview = "Odysseus, the legendary King of Ithaca, embarks on a long and perilous journey home following the Trojan War. Throughout his voyage, he is forced to confront the whims of gods, mythological monsters, and trials that stretch both his cunning and his humanity to the breaking point.",
            posterPath = "https://image.tmdb.org/t/p/w500//5rhTDKUhPYvpdQIijFIs5VoWsON.jpg",
            rating = 8.014
        ),
        Movie(
            id = 1291595,
            title = "Insidious: Out of the Further",
            overview = "Gemma, a young mother raising her daughter in the house she grew up in, discovers she can travel into The Further, the purgatorial realm of lost souls at the heart of the Insidious universe. When something evil comes after her, Gemma discovers an ability that changes everything: she doesn't just enter The Further, she can bring what lives there back to the real world. Once the demons realize her power, our world becomes their playground.",
            posterPath = "https://image.tmdb.org/t/p/w500//4tTrW9dXCByS5wt2pXVWb58zNjz.jpg",
            rating = 7.548
        ),
        Movie(
            id = 1228834,
            title = "The Fix",
            overview = "Disillusioned by the end of the war in Afghanistan, a group of disgraced, war-torn ex-CIA operatives set out to Tehran to take down a life-changing score.",
            posterPath = "https://image.tmdb.org/t/p/w500//yopXjun3ICFfJci2ukcEzceZjUs.jpg",
            rating = 6.76
        )
    )

    val emptyMovies = emptyList<Movie>()
}