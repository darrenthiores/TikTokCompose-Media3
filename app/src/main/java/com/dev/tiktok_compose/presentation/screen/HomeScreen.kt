package com.dev.tiktok_compose.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.IosShare
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.dev.tiktok_compose.presentation.component.HomeList
import com.dev.tiktok_compose.presentation.component.HomeTopBar
import com.dev.tiktok_compose.presentation.component.IconWithText
import com.dev.tiktok_compose.presentation.holder.HomeState
import com.dev.tiktok_compose.presentation.holder.rememberHomeState
import com.dev.tiktok_compose.presentation.navigation.HomeTab
import com.dev.tiktok_compose.presentation.viewModel.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    homeState: HomeState = rememberHomeState()
) {
    val allTabs = HomeTab.values().toList()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalPager(
            count = allTabs.size,
            modifier = Modifier
                .align(Alignment.Center),
            state = homeState.pagerState
        ) { page ->
            HomeContent(
                modifier = Modifier,
                page = page,
                viewModel = viewModel
            )
        }

        HomeTopBar(
            pagerState = homeState.pagerState,
            allScreens = allTabs,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.TopCenter)
        )
    }
}

@ExperimentalPagerApi
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    page: Int,
    viewModel: HomeViewModel
) {
    when(page) {
        0 -> {

        }
        1 -> {

        }
        2 -> {
            val feeds = viewModel.feeds.collectAsState()
            HomeList(
                modifier = modifier,
                feeds = feeds.value
            )
        }
    }
}