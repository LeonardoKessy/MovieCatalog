package com.seminario.moviecatalog.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieFetchState : MutableStateFlow<MovieFetchState> = MutableStateFlow(MovieFetchState.Loading)
    val movieFetchState : StateFlow<MovieFetchState> = _movieFetchState.asStateFlow()


    init {

    }


    private fun getMovie(id: Int) {

    }

}


sealed class MovieFetchState {
    object Loading : MovieFetchState()
    data class Success(val movie: Movie) : MovieFetchState()
    data class Error(val message: String) : MovieFetchState()
}
