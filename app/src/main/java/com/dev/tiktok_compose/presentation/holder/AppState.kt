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

class AppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController
) {
    
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController()
): AppState = remember(scaffoldState, navController) {
    AppState(
        scaffoldState,
        navController
    )
}