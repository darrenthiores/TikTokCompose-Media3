package com.dev.tiktok_compose.data.dummy

import com.dev.tiktok_compose.data.model.Feed
import com.dev.tiktok_compose.data.model.User

object GenerateDummy {
    fun listOfFeed(): List<Feed> =
        List(10) {
            Feed(
                feed_id = it.toString(),
                user = User(
                    user_id = it.toString(),
                    name = "user-$it",
                    profile_picture = generateProfilePicture()[it]
                ),
                video_url = generateVideoUrl()[it],
                description = "Video number $it",
                likes = it.toLong(),
                comments = it.toLong(),
                shares = it.toLong()
            )
        }

    private fun generateVideoUrl(): List<String> =
        listOf(
            "https://ak.picdn.net/shutterstock/videos/1070767552/preview/stock-footage-beef-burger-ingredients-falling-and-landing-in-the-bun-one-by-one-in-slow-motion-fps.webm",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"
        )

    private fun generateProfilePicture(): List<String> =
        listOf(
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png",
            "https://cdn.icon-icons.com/icons2/2643/PNG/512/female_woman_person_people_avatar_icon_159366.png"
        )
}