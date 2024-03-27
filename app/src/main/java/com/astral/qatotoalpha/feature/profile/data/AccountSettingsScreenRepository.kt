package com.astral.qatotoalpha.feature.profile.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.ForwardToInbox
import androidx.compose.material.icons.filled.AddIcCall
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.SwitchAccount
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.profile.domain.AccountSettingsScreenModel

class AccountSettingsScreenRepository {
    fun getAllData(): List<AccountSettingsScreenModel> {
        return listOf(
            AccountSettingsScreenModel(
                accountSettingsId = 0,
                accountSettingsImageVector = Icons.Filled.SwitchAccount,
                accountSettingsText = R.string.switch_account
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 1,
                accountSettingsImageVector = Icons.AutoMirrored.Filled.ExitToApp,
                accountSettingsText = R.string.sign_out
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 2,
                accountSettingsImageVector = Icons.Filled.Storage,
                accountSettingsText = R.string.your_data_in_app_account
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 3,
                accountSettingsImageVector = Icons.Filled.Lock,
                accountSettingsText = R.string.set_password
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 4,
                accountSettingsImageVector = Icons.Filled.AlternateEmail,
                accountSettingsText = R.string.set_handle
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 5,
                accountSettingsImageVector = Icons.Filled.AddIcCall,
                accountSettingsText = R.string.set_phone_number
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 6,
                accountSettingsImageVector = Icons.Filled.AddPhotoAlternate,
                accountSettingsText = R.string.set_profile_photo
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 7,
                accountSettingsImageVector = Icons.Filled.Mail,
                accountSettingsText = R.string.set_email_address
            ),
            AccountSettingsScreenModel(
                accountSettingsId = 8,
                accountSettingsImageVector = Icons.AutoMirrored.Filled.ForwardToInbox,
                accountSettingsText = R.string.set_recovery_email_address
            )
        )
    }
}