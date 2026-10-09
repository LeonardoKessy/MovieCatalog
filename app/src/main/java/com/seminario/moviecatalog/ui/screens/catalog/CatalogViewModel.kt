package com.seminario.moviecatalog.ui.screens.catalog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    var movieFetchState by mutableStateOf<MovieFetchState>(MovieFetchState.Loading)
        private set


    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            movieFetchState = MovieFetchState.Loading

            try {
                val movies: List<Movie> = repository.getPopularMovies();

                movieFetchState = MovieFetchState.Success(movies)

            } catch (e: Exception) {
                movieFetchState = MovieFetchState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class MovieFetchState {
    object Loading : MovieFetchState()
    data class Success(val movies: List<Movie>) : MovieFetchState()
    data class Error(val message: String) : MovieFetchState()
}