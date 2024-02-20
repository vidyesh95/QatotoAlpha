package com.astral.qatotoalpha.util.repository

import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.util.model.ShortsModel

class ShortsRepository {
    fun getAllData(): List<ShortsModel> {
        return listOf(
            ShortsModel(
                shortsId = "1",
                isLive = false,
                shortsThumbnail = R.drawable.shorts_thumbnail_1,
                profileImage = R.drawable.profile_image_1,
                shortsTitle = "Pomporo singing \uD83C\uDF3CFengzhi Senai\uD83C\uDF3C at Disney Land",
                channelName = "Arin Light",
                shortsWatching = "0",
                shortsViews = "2.5M",
                shortsDuration = "12 hours",
                shortsLength = "12:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            ShortsModel(
                shortsId = "2",
                isLive = false,
                shortsThumbnail = R.drawable.shorts_thumbnail_2,
                profileImage = R.drawable.profile_image_2,
                shortsTitle = "Need for speed @234MPH",
                channelName = "BTS fan boi\uD83E\uDD29",
                shortsWatching = "0",
                shortsViews = "973",
                shortsDuration = "37 minutes",
                shortsLength = "1:32:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            ShortsModel(
                shortsId = "3",
                isLive = true,
                shortsThumbnail = R.drawable.shorts_thumbnail_3,
                profileImage = R.drawable.profile_image_3,
                shortsTitle = "Your everyday slicing made easy - cucumber, carrot, radish in snap",
                channelName = "Home owners friend",
                shortsWatching = "9k",
                shortsViews = "0",
                shortsDuration = "0",
                shortsLength = "0:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            ShortsModel(
                shortsId = "4",
                isLive = true,
                shortsThumbnail = R.drawable.shorts_thumbnail_4,
                profileImage = R.drawable.profile_image_4,
                shortsTitle = "Shorts 4",
                channelName = "channel 4",
                shortsWatching = "0",
                shortsViews = "0",
                shortsDuration = "0",
                shortsLength = "00:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            ShortsModel(
                shortsId = "5",
                isLive = false,
                shortsThumbnail = R.drawable.shorts_thumbnail_5,
                profileImage = R.drawable.profile_image_1,
                shortsTitle = "Shorts 5",
                channelName = "channel 5",
                shortsWatching = "0",
                shortsViews = "0",
                shortsDuration = "0 sec",
                shortsLength = "0:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            ShortsModel(
                shortsId = "6",
                isLive = false,
                shortsThumbnail = R.drawable.shorts_thumbnail_6,
                profileImage = R.drawable.profile_image_2,
                shortsTitle = "shorts 6",
                channelName = "channel 6",
                shortsWatching = "0",
                shortsViews = "0",
                shortsDuration = "0 sec",
                shortsLength = "0:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            ShortsModel(
                shortsId = "7",
                isLive = true,
                shortsThumbnail = R.drawable.shorts_thumbnail_7,
                profileImage = R.drawable.profile_image_3,
                shortsTitle = "shorts 7",
                channelName = "channel 7",
                shortsWatching = "0",
                shortsViews = "0",
                shortsDuration = "0",
                shortsLength = "0:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            ),
            ShortsModel(
                shortsId = "8",
                isLive = true,
                shortsThumbnail = R.drawable.shorts_thumbnail_8,
                profileImage = R.drawable.profile_image_4,
                shortsTitle = "shorts 8",
                channelName = "channel 8",
                shortsWatching = "0",
                shortsViews = "0",
                shortsDuration = "0",
                shortsLength = "00:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            )
        )
    }
}