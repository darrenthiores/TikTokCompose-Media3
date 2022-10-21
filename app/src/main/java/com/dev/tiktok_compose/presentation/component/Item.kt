package com.dev.tiktok_compose.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.dev.tiktok_compose.data.model.Feed

@Composable
fun FeedItem(
    modifier: Modifier = Modifier,
    feed: Feed,
    play: Boolean
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        VideoPlayer(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            url = feed.video_url,
            play = play
        )

        TitleAndDescriptionText(
            modifier = Modifier
                .padding(start = 8.dp, bottom = 36.dp)
                .fillMaxWidth(0.75f)
                .align(Alignment.BottomStart),
            title = feed.user.name,
            description = feed.description
        )

        HomeSideBar(
            modifier = Modifier
                .padding(end = 8.dp, bottom = 36.dp)
                .align(Alignment.BottomEnd),
            profile_picture = feed.user.profile_picture,
            likes = feed.likes,
            comments = feed.comments,
            shares = feed.shares
        )
    }
}

@Composable
private fun HomeSideBar(
    modifier: Modifier = Modifier,
    profile_picture: String,
    likes: Long,
    comments: Long,
    shares: Long
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.onBackground, CircleShape),
                painter = rememberAsyncImagePainter(profile_picture),
                contentDescription = "profile picture"
            )
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.BottomCenter)
                    .offset(
                        y = 10.dp
                    )
                    .background(
                        color = Color.Red,
                        shape = CircleShape
                    ),
                tint = MaterialTheme.colors.onBackground
            )
        }

        IconWithText(
            modifier = Modifier
                .padding(top = 32.dp),
            icon = Icons.Default.Favorite,
            text = likes.toString()
        ) {

        }

        IconWithText(
            modifier = Modifier
                .padding(top = 16.dp),
            icon = Icons.Default.Comment,
            text = comments.toString()
        ) {

        }

        IconWithText(
            modifier = Modifier
                .padding(top = 16.dp),
            icon = Icons.Default.Share,
            text = shares.toString()
        ) {

        }
    }
}