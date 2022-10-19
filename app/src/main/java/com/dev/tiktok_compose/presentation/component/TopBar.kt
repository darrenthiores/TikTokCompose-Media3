package com.dev.tiktok_compose.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.tiktok_compose.presentation.navigation.HomeTab
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    allScreens: List<HomeTab>
) {
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
//            TabRowDefaults
//                .Indicator(
//                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
//                )
            Box(
                modifier = Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                    .padding(horizontal = 28.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = MaterialTheme.colors.onBackground)
            )
        },
        divider = {  },
        backgroundColor = Color.Transparent,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        allScreens.forEachIndexed { index, screen ->
            Tab(
                text = { Text(screen.name) },
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } }
            )
        }
    }
}