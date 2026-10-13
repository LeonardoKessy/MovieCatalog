package com.seminario.moviecatalog.ui.screens.detail

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.seminario.moviecatalog.ui.theme.MovieCatalogTheme

@Composable
fun DetailScreen(
    movieId: Int
) {



    DetailContent()

}

@Composable
fun DetailContent(

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
        DetailContent()
    }
}