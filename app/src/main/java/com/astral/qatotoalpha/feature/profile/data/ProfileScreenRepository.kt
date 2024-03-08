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
import com.astral.qatotoalpha.feature.profile.domain.ProfileScreenModel

class ProfileScreenRepository {
    fun getAllData(): List<ProfileScreenModel> {
        return listOf(
            ProfileScreenModel(
                profileId = 0,
                profileImageVector = Icons.Filled.ModeNight,
                profileText = "Night light"
            ),
            ProfileScreenModel(
                profileId = 1,
                profileImageVector = Icons.Filled.InvertColors,
                profileText = "App theme"
            ),
            ProfileScreenModel(
                profileId = 2,
                profileImageVector = Icons.Filled.NoAccounts,
                profileText = "Turn on incognito"
            ),
            ProfileScreenModel(
                profileId = 3,
                profileImageVector = Icons.Filled.Language,
                profileText = "App language"
            ),
            ProfileScreenModel(
                profileId = 4,
                profileImageVector = Icons.Filled.Settings,
                profileText = "Settings"
            ),
            ProfileScreenModel(
                profileId = 5,
                profileImageVector = Icons.Filled.ModeOfTravel,
                profileText = "Drive mode"
            ),
            ProfileScreenModel(
                profileId = 6,
                profileImageVector = Icons.Filled.ChildCare,
                profileText = "Child mode"
            ),
            ProfileScreenModel(
                profileId = 7,
                profileImageVector = Icons.Filled.BarChart,
                profileText = "Time watched"
            ),
            ProfileScreenModel(
                profileId = 8,
                profileImageVector = Icons.Filled.Storage,
                profileText = "Your data in app account"
            ),
            ProfileScreenModel(
                profileId = 9,
                profileImageVector = Icons.Filled.StarRate,
                profileText = "Rate us on play store"
            ),
            ProfileScreenModel(
                profileId = 10,
                profileImageVector = Icons.Filled.Feedback,
                profileText = "Feedback"
            ),
            ProfileScreenModel(
                profileId = 11,
                profileImageVector = Icons.Filled.Forum,
                profileText = "Forum"
            ),
            ProfileScreenModel(
                profileId = 12,
                profileImageVector = Icons.AutoMirrored.Filled.HelpCenter,
                profileText = "Help center"
            ),
            ProfileScreenModel(
                profileId = 13,
                profileImageVector = Icons.Filled.PrivacyTip,
                profileText = "Privacy policy"
            ),
            ProfileScreenModel(
                profileId = 14,
                profileImageVector = Icons.Filled.ControlPointDuplicate,
                profileText = "Terms of service"
            )
        )
    }
}