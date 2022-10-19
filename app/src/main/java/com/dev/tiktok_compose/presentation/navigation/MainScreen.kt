package com.dev.tiktok_compose.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainScreen(
    val icon: ImageVector
) {
    Home(
        icon = Icons.Default.Home
    ),
    Shop(
        icon = Icons.Default.ShoppingBag
    ),
    Post(
        icon = Icons.Default.Add
    ),
    Inbox(
        icon = Icons.Default.Inbox
    ),
    Profile(
        icon = Icons.Default.Person
    );

    companion object{
        fun fromRoute(route: String?): MainScreen =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                Shop.name -> Shop
                Inbox.name -> Inbox
                Profile.name -> Profile
                null -> Home
                else -> Home //throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}