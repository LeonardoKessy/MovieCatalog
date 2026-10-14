package com.seminario.moviecatalog.ui.screens.detail

import android.content.res.Configuration
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.seminario.moviecatalog.R
import com.seminario.moviecatalog.ui.mock.MockData
import com.seminario.moviecatalog.ui.screens.shared.components.ErrorCard
import com.seminario.moviecatalog.ui.theme.MovieCatalogTheme

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    goBack: () -> Unit
) {

    val movieFetchState by viewModel.movieFetchState.collectAsState()

    DetailContent(
        movieFetchState = movieFetchState,
        goBack = goBack
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(
    movieFetchState: MovieFetchState,
    goBack: () -> Unit
) {

    Scaffold(
        Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.catalog_header),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.titleMedium
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
                .fillMaxSize(),
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

                }

                is MovieFetchState.Error -> {
                    ErrorCard(
                        message = movieFetchState.message,
                        onRetry = goBack,
                        buttonMessage = "Go Back"
                    )
                }
            }

        }

    }

}

@Composable
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
fun DetailScreenPreview() {
    MovieCatalogTheme {
        DetailContent(
            movieFetchState = MovieFetchState.Success(MockData.movieDetail),
            goBack = {}
        )
    }
}