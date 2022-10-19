package com.dev.tiktok_compose.data.model

data class Feed(
    val feed_id: String,
    val user: User,
    val video_url: String,
    val description: String,
    val likes: Long,
    val comments: Long,
    val shares: Long
)
