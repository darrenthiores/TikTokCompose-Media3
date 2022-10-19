package com.dev.tiktok_compose.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dev.tiktok_compose.data.model.Feed
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun HomeList(
    modifier: Modifier = Modifier,
    state: PagerState = rememberPagerState(),
    feeds: List<Feed>
) {
    VerticalPager(
        count = feeds.size,
        state = state,
        modifier = modifier
    ) { index ->
        val feed = feeds[index]
        val playNow = remember {
            derivedStateOf {
                state.currentPage == index
            }
        }

        FeedItem(
            modifier = Modifier,
            feed = feed,
            play = playNow.value
        )
    }
}