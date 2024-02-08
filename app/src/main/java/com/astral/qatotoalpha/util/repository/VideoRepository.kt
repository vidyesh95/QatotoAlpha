package com.astral.qatotoalpha.util.repository

import com.astral.qatotoalpha.util.model.VideoModel

class VideoRepository {
    fun getAllData(): List<VideoModel> {
        return listOf(
            VideoModel(
                videoId = "1",
                videoThumbnail = "video_thumbnail_1",
                isLive = false,
                profileImage = "profile_image_1",
                videoTitle = "Pomporo singing \uD83C\uDF3CFengzhi Senai\uD83C\uDF3C at Disney Land",
                videoChannel = "Arin Light",
                videoViews = "2.5M",
                videoDuration = "12 hours",
                videoLength = "12:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            VideoModel(
                videoId = "2",
                videoThumbnail = "video_thumbnail_2",
                isLive = false,
                profileImage = "profile_image_2",
                videoTitle = "Need for speed @234MPH",
                videoChannel = "BTS fan boi\uD83E\uDD29",
                videoViews = "973",
                videoDuration = "37 minutes",
                videoLength = "1:32:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            VideoModel(
                videoId = "3",
                videoThumbnail = "video_thumbnail_3",
                isLive = true,
                profileImage = "profile_image_3",
                videoTitle = "Your everyday slicing made easy - cucumber, carrot, radish in snap",
                videoChannel = "Home owners friend",
                videoViews = "9k",
                videoDuration = "Live",
                videoLength = "0:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            VideoModel(
                videoId = "4",
                videoThumbnail = "video_thumbnail_4",
                isLive = true,
                profileImage = "profile_image_4",
                videoTitle = "Driving on Tour de Auto Weisseir",
                videoChannel = "BMW Girl",
                videoViews = "275K ",
                videoDuration = "Live",
                videoLength = "00:00",
                videoUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            )
        )
    }
}