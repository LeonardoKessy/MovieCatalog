package com.seminario.moviecatalog.ui.screens.detail

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.seminario.moviecatalog.R

@Composable
fun DetailActionButtons(
    movieTitle: String,
    movieOverview: String,
    homepageUrl: String?
) {

    val context = LocalContext.current


    val shareText = stringResource(id = R.string.share_movie_message, movieTitle, movieOverview)
    val homepageShareText =
        if (!homepageUrl.isNullOrEmpty()) "$shareText\n\n$homepageUrl"
        else shareText

    Row(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        IconButton(
            onClick = {

                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareText)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, "Share Movie")
                context.startActivity(shareIntent)
            }
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share Icon.",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(32.dp)
            )
        }

        if (!homepageUrl.isNullOrEmpty()) {
            IconButton(
                onClick = {
                    val webIntent = Intent(Intent.ACTION_VIEW, homepageUrl.toUri())
                    context.startActivity(webIntent)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Homepage Icon.",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(32.dp)
                )
            }
        }
    }
}