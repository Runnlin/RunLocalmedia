package io.github.runnlin.myplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.runnlin.myplayer.ui.theme.MyPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MediaCard(media = MediaFile("test music", false))
                }
            }

        }
    }
}

data class MediaFile(val title: String, val isVideo: Boolean)

@Composable
fun MediaCard(media: MediaFile) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(
                id = if (media.isVideo) {
                    R.drawable.ic_video_library
                } else {
                    R.drawable.ic_audiotrack
                }
            ),
            contentDescription = "Content audio",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = media.title,
                color = MaterialTheme.colorScheme.primary
            )
            Row() {
                Surface(shape = MaterialTheme.typography.) {

                }
                Image(
                    painter = painterResource(
                        id = if (media.isVideo) {
                            R.drawable.ic_video_library
                        } else {
                            R.drawable.ic_audiotrack
                        }
                    ),
                    contentDescription = "Content audio",
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMediaCard() {
    MyPlayerTheme {
        MediaCard(media = MediaFile("test Video", true))
    }
}
