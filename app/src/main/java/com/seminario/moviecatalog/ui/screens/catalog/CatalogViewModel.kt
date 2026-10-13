package com.seminario.moviecatalog.ui.screens.catalog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private var _moviesFetchState = MutableStateFlow<MoviesFetchState>(MoviesFetchState.Loading)
    val moviesFetchState : StateFlow<MoviesFetchState> = _moviesFetchState.asStateFlow()


    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            _moviesFetchState.value = MoviesFetchState.Loading

            try {
                val movies: List<Movie> = repository.getPopularMovies();

                _moviesFetchState.value = MoviesFetchState.Success(movies)

            } catch (e: Exception) {
                _moviesFetchState.value = MoviesFetchState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class MoviesFetchState {
    object Loading : MoviesFetchState()
    data class Success(val movies: List<Movie>) : MoviesFetchState()
    data class Error(val message: String) : MoviesFetchState()
}