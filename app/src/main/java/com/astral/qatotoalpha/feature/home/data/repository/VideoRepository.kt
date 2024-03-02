package com.astral.qatotoalpha.feature.home.data.repository

import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.home.domain.model.VideoModel

class VideoRepository {
    fun getAllData(): List<VideoModel> {
        return listOf(
            VideoModel(
                videoId = "1",
                isLive = false,
                videoThumbnail = R.drawable.video_thumbnail_1,
                profileImage = R.drawable.profile_image_1,
                videoTitle = "Pomporo singing \uD83C\uDF3CFengzhi Senai\uD83C\uDF3C at Disney Land",
                channelName = "Arin Light",
                videoWatching = "0",
                videoViews = "2.5M",
                videoDuration = "12 hours",
                videoLength = "12:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            VideoModel(
                videoId = "2",
                isLive = false,
                videoThumbnail = R.drawable.video_thumbnail_2,
                profileImage = R.drawable.profile_image_2,
                videoTitle = "Need for speed @234MPH",
                channelName = "BTS fan boi\uD83E\uDD29",
                videoWatching = "0",
                videoViews = "973",
                videoDuration = "37 minutes",
                videoLength = "1:32:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            VideoModel(
                videoId = "3",
                isLive = true,
                videoThumbnail = R.drawable.video_thumbnail_3,
                profileImage = R.drawable.profile_image_3,
                videoTitle = "Your everyday slicing made easy - cucumber, carrot, radish in snap",
                channelName = "Home owners friend",
                videoWatching = "9k",
                videoViews = "0",
                videoDuration = "0",
                videoLength = "0:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            VideoModel(
                videoId = "4",
                isLive = true,
                videoThumbnail = R.drawable.video_thumbnail_4,
                profileImage = R.drawable.profile_image_4,
                videoTitle = "Driving on Tour de Auto Weisseir",
                channelName = "BMW Girl",
                videoWatching = "275K",
                videoViews = "0",
                videoDuration = "0",
                videoLength = "00:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            )
        )
    }
}