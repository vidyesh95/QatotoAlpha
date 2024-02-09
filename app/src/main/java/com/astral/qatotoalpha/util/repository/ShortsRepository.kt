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
                shortsTitle = "Driving on Tour de Auto Weisseir",
                channelName = "BMW Girl",
                shortsWatching = "275K",
                shortsViews = "0",
                shortsDuration = "0",
                shortsLength = "00:00",
                shortsUrl = "https://www.youtube.com/watch?v=3T3fXqzE8ZQ"
            )
        )
    }
}