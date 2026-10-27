package com.seminario.moviecatalog.ui.screens.catalog

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
fun CatalogScreen(
    onMovieClick: (String) -> Unit,
    viewModel: CatalogViewModel = hiltViewModel()
) {

    val movieFetchState by viewModel.moviesFetchState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    CatalogContent(
        moviesFetchState = movieFetchState,
        onRetry = { viewModel.getMovies() },
        onMovieClick = onMovieClick,
        searchQuery = searchQuery,
        onSearchQueryChange = viewModel::onSearchQueryChange
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogContent(
    moviesFetchState : MoviesFetchState,
    onRetry: () -> Unit,
    onMovieClick: (String) -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit

) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
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

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { onSearchQueryChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = innerPadding.calculateTopPadding().plus(16.dp),
                    start = 16.dp,
                    end = 16.dp
                )
                .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colorScheme.surfaceContainer),
            placeholder = {
                Text(
                    text = stringResource(R.string.search_placeholder),
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search bar") }
        )

        Box(
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding().plus(75.dp)
                )
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {

            when (moviesFetchState) {
                is MoviesFetchState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                is MoviesFetchState.Success -> {
                    if (moviesFetchState.movies.isEmpty()) {
                        Box(
                            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                        ) {
                            Text(text = stringResource(R.string.no_results_found))
                        }
                    } else {
                        CatalogGrid(
                            movies = moviesFetchState.movies,
                            onMovieClick = onMovieClick,
                        )
                    }
                }

                is MoviesFetchState.Error -> {
                    ErrorCard(
                        message = stringResource(R.string.catalog_error),
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
            moviesFetchState = MoviesFetchState.Success(movies = MockData.movies),
            onRetry = {},
            onMovieClick = {},
            searchQuery = "",
            onSearchQueryChange = {}
        )
    }
}