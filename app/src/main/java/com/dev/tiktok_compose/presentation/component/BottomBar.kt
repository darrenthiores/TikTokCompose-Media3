package com.dev.tiktok_compose.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.tiktok_compose.presentation.navigation.MainScreen

@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    allScreens: List<MainScreen>,
    onTabSelected: (MainScreen) -> Unit,
    currentScreen: MainScreen,
    onAddPostClicked: () -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = Color.LightGray
    ) {
        allScreens.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    if(screen == MainScreen.Post) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colors.onBackground)
                                .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.name,
                                tint = MaterialTheme.colors.surface
                            )
                        }
                    } else {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.name
                            )
                            Text(
                                text = screen.name,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }
                },
                selected = currentScreen == screen,
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color.LightGray,
                onClick = {
                    if(screen == MainScreen.Post) {
                        onAddPostClicked()
                    } else {
                        onTabSelected(screen)
                    }
                }
            )
        }
    }
}