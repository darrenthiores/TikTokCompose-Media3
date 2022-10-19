package com.dev.tiktok_compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dev.tiktok_compose.presentation.component.MainBottomBar
import com.dev.tiktok_compose.presentation.holder.AppState
import com.dev.tiktok_compose.presentation.holder.rememberAppState
import com.dev.tiktok_compose.presentation.navigation.MainScreen
import com.dev.tiktok_compose.presentation.screen.HomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun TiktokApp(
    appState: AppState = rememberAppState()
) {
    val allScreens = MainScreen.values().toList()
    val backStackEntry = appState.navController.currentBackStackEntryAsState()
    val currentScreen = MainScreen.fromRoute(
        backStackEntry.value?.destination?.route
    )

    Scaffold(
        scaffoldState = appState.scaffoldState,
        bottomBar = {
            MainBottomBar(
                allScreens = allScreens,
                onTabSelected = { screen -> appState.navController.navigate(screen.name) },
                currentScreen = currentScreen
            ) {

            }
        }
    ) { paddingValues ->
        MainNavHost(
            modifier = Modifier
                .padding(paddingValues),
            navController = appState.navController
        )
    }
}

@ExperimentalPagerApi
@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MainScreen.Home.name
    ) {
        composable(MainScreen.Home.name) {
            HomeScreen()
        }
    }
}