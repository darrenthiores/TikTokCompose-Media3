package com.dev.tiktok_compose.presentation.holder

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dev.tiktok_compose.presentation.navigation.MainScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
class HomeState(
    val scaffoldState: ScaffoldState,
    val pagerState: PagerState,
) {
    
}

@ExperimentalPagerApi
@Composable
fun rememberHomeState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    pagerState: PagerState = rememberPagerState(3)
): HomeState = remember(scaffoldState, pagerState) {
    HomeState(
        scaffoldState,
        pagerState
    )
}