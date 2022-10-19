package com.dev.tiktok_compose.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TitleAndDescriptionText(
    modifier: Modifier = Modifier,
    title: String = "",
    description: String = ""
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            text = description,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String,
    onIconClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable { onIconClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            modifier = Modifier
                .size(32.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle2
        )
    }
}