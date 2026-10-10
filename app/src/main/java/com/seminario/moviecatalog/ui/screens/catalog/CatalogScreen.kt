package com.seminario.moviecatalog.ui.screens.catalog

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.seminario.moviecatalog.ui.mock.MockData
import com.seminario.moviecatalog.ui.screens.shared.components.ErrorCard
import com.seminario.moviecatalog.ui.theme.MovieCatalogTheme

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel = hiltViewModel()
) {

    val movieFetchState = viewModel.movieFetchState
    if (movieFetchState is MovieFetchState.Success) println(movieFetchState.movies)

    CatalogContent(
        movieFetchState = movieFetchState,
        onRetry = { viewModel.getMovies() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogContent(
    movieFetchState: MovieFetchState,
    onRetry: () -> Unit
) {

    println(movieFetchState)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Movie catalog",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.titleSmall
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {

            when (movieFetchState) {
                is MovieFetchState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                is MovieFetchState.Success -> {
                    Text(text = "Success")
                }

                is MovieFetchState.Error -> {
                    ErrorCard(
                        message = "Error has occurred fetching movies",
                        onRetry = onRetry
                    )
                }
            }

        }


    }
}


@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun CatalogScreenPreview() {
    MovieCatalogTheme {
        CatalogContent(
            movieFetchState = MovieFetchState.Success(movies = MockData.movies),
            onRetry = {}
        )
    }
}