package com.astral.qatotoalpha.feature.auth.presentation.forgotpass

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.ui.theme.QatotoAlphaTheme

@Composable
fun ForgotPassScreen() {
    ForgotPassPage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPassPage() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    QatotoAlphaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(connection = scrollBehavior.nestedScrollConnection),
                topBar = {
                    LargeTopAppBar(
                        title = {
                            Text(
                                text = "Forgot Password"
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior
                    )
                }
            ) { innerPadding ->
                ForgotPassScreenContent(innerPadding)
            }
        }
    }
}

@Composable
fun ForgotPassScreenContent(innerPadding: PaddingValues) {
    // Handle or Email text field
    var emailHandleText by remember { mutableStateOf("") }

    // Forgot password content
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(innerPadding)
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Handle or Email text field
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = emailHandleText,
            onValueChange = {
                emailHandleText = it
            },
            label = {
                Text("Handle or Email")
            },
            supportingText = {
                Text("Enter either handle or email")
            },
            placeholder = {
                Text("@user_name")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )

        // Sign in with password button
        FilledIconButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { /*TODO*/ }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email"
                )
                Text(
                    text = "Send email link",
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }

        // or continue with divider
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp),
            )
            Text(
                modifier = Modifier.wrapContentSize(),
                text = "or continue with",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp),
            )
        }

        // google and apple login buttons
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedIconButton(
                modifier = Modifier
                    .width(width = 56.dp)
                    .wrapContentHeight(),
                colors = IconButtonDefaults.outlinedIconButtonColors(
                    containerColor = Color.White.copy(alpha = 0.2f),
                ),
                onClick = { /*TODO*/ }
            ) {
                Image(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.google_logo_light),
                    contentDescription = "Continue with Google"
                )
            }

            OutlinedIconButton(
                modifier = Modifier
                    .width(width = 56.dp)
                    .wrapContentHeight(),
                colors = IconButtonDefaults.outlinedIconButtonColors(
                    containerColor = Color.White.copy(alpha = 0.2f),
                ),
                onClick = { /*TODO*/ }
            ) {
                Image(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.apple_logo_light),
                    contentDescription = "Continue with Apple"
                )
            }
        }

        // Sign up button
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Don't have an account?",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Text(
                text = "Sign up",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // Spacer to make all content visible when keyboard is open
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        )
    }
}

//@PreviewScreenSizes
//@PreviewDynamicColors
@PreviewLightDark
@Composable
fun ForgotPassScreenPreview() {
    ForgotPassPage()
}