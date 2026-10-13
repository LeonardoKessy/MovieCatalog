package com.seminario.moviecatalog.ui.screens.detail

import androidx.lifecycle.ViewModel
import com.seminario.moviecatalog.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}