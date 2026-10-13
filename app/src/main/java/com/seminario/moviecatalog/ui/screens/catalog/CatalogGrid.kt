package com.seminario.moviecatalog.ui.screens.catalog

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seminario.moviecatalog.domain.model.Movie
import com.seminario.moviecatalog.ui.mock.MockData
import com.seminario.moviecatalog.ui.theme.MovieCatalogTheme

@Composable
fun CatalogGrid(
    movies : List<Movie>,
    onMovieClick : (String) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(movies) { movie ->
            CatalogCard(
                movie = movie,
                onClick = onMovieClick
            )
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
fun CatalogGridPreview() {
    MovieCatalogTheme {
        CatalogGrid(
            movies = MockData.movies,
            onMovieClick = {}
        )
    }
}
