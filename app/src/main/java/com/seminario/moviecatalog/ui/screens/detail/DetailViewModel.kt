package com.seminario.moviecatalog.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seminario.moviecatalog.R
import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.model.MovieDetail
import com.seminario.moviecatalog.domain.repository.MovieRepository
import com.seminario.moviecatalog.ui.util.UiText
import com.seminario.moviecatalog.ui.util.UiText.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieFetchState : MutableStateFlow<MovieFetchState> = MutableStateFlow(MovieFetchState.Loading)
    val movieFetchState : StateFlow<MovieFetchState> = _movieFetchState.asStateFlow()


    init {
        _movieFetchState.value = MovieFetchState.Loading

        val movieId = savedStateHandle.get<Int>("movieId") ?: -1

        if (movieId != -1) getMovie(movieId)
        else _movieFetchState.value = MovieFetchState.Error(StringResource(R.string.movie_error))
    }


    private fun getMovie(id: Int) {
        viewModelScope.launch {
            try {
                val movie = repository.getMovie(id)
                _movieFetchState.value = MovieFetchState.Success(movie)
            } catch (e: Exception) {
                _movieFetchState.value = MovieFetchState.Error(StringResource(R.string.unknown_error))
            }
        }
    }

}


sealed class MovieFetchState {
    object Loading : MovieFetchState()
    data class Success(val movie: MovieDetail) : MovieFetchState()
    data class Error(val message: UiText) : MovieFetchState()
}
