package com.astral.qatotoalpha.feature.profile.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpCenter
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.ControlPointDuplicate
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.InvertColors
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material.icons.filled.ModeOfTravel
import androidx.compose.material.icons.filled.NoAccounts
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.filled.Storage
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.profile.domain.ProfileScreenModel

class ProfileScreenRepository {
    fun getAllData(): List<ProfileScreenModel> {
        return listOf(
            ProfileScreenModel(
                profileId = 0,
                profileImageVector = Icons.Filled.ModeNight,
                profileText = R.string.night_light
            ),
            ProfileScreenModel(
                profileId = 1,
                profileImageVector = Icons.Filled.InvertColors,
                profileText = R.string.app_theme
            ),
            ProfileScreenModel(
                profileId = 2,
                profileImageVector = Icons.Filled.NoAccounts,
                profileText = R.string.turn_on_incognito
            ),
            ProfileScreenModel(
                profileId = 3,
                profileImageVector = Icons.Filled.Language,
                profileText = R.string.app_language
            ),
            ProfileScreenModel(
                profileId = 4,
                profileImageVector = Icons.Filled.Settings,
                profileText = R.string.settings
            ),
            ProfileScreenModel(
                profileId = 5,
                profileImageVector = Icons.Filled.ModeOfTravel,
                profileText = R.string.drive_mode
            ),
            ProfileScreenModel(
                profileId = 6,
                profileImageVector = Icons.Filled.ChildCare,
                profileText = R.string.child_mode
            ),
            ProfileScreenModel(
                profileId = 7,
                profileImageVector = Icons.Filled.BarChart,
                profileText = R.string.time_watched
            ),
            ProfileScreenModel(
                profileId = 8,
                profileImageVector = Icons.Filled.Storage,
                profileText = R.string.your_data_in_app_account
            ),
            ProfileScreenModel(
                profileId = 9,
                profileImageVector = Icons.Filled.StarRate,
                profileText = R.string.rate_us_on_play_store
            ),
            ProfileScreenModel(
                profileId = 10,
                profileImageVector = Icons.Filled.Feedback,
                profileText = R.string.feedback
            ),
            ProfileScreenModel(
                profileId = 11,
                profileImageVector = Icons.Filled.Forum,
                profileText = R.string.forum
            ),
            ProfileScreenModel(
                profileId = 12,
                profileImageVector = Icons.AutoMirrored.Filled.HelpCenter,
                profileText = R.string.help_center
            ),
            ProfileScreenModel(
                profileId = 13,
                profileImageVector = Icons.Filled.PrivacyTip,
                profileText = R.string.privacy_policy
            ),
            ProfileScreenModel(
                profileId = 14,
                profileImageVector = Icons.Filled.ControlPointDuplicate,
                profileText = R.string.terms_of_service
            )
        )
    }
}