package com.seminario.moviecatalog.ui.screens.detail

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.seminario.moviecatalog.ui.mock.MockData
import com.seminario.moviecatalog.ui.theme.MovieCatalogTheme

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    movieId: Int
) {

    val movieFetchState by viewModel.movieFetchState.collectAsState()

    DetailContent(
        movieFetchState = movieFetchState
    )

}

@Composable
fun DetailContent(
    movieFetchState: MovieFetchState
) {

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
            movieFetchState = MovieFetchState.Success(MockData.singleMovie)
        )
    }
}