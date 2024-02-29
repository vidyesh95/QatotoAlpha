package com.astral.qatotoalpha.feature.firsttime.presentation

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.ui.theme.QatotoAlphaTheme
import com.astral.qatotoalpha.ui.theme.Typography
import com.astral.qatotoalpha.util.FirstTimeScreen

@Composable
fun FirstScreen(navController: NavController) {
    FirstPage(navController = navController)
}

@Composable
fun FirstPage(navController: NavController) {
    QatotoAlphaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TermsPageContainer(navController = navController)
        }
    }
}

@Composable
fun TermsPageContainer(navController: NavController) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences(
        "myPref", Context.MODE_PRIVATE
    )
    val editor = sharedPref.edit()
    Column(
        modifier = Modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContinueText(
            modifier = Modifier.wrapContentSize()
        )

        ContinueButton(
            modifier = Modifier
                .width(width = 226.dp)
                .wrapContentHeight()
                .padding(top = 16.dp),
            onClick = {
                editor.apply {
                    putBoolean("isContinueAccepted", true)
                    apply()
                }
                navController.navigate(FirstTimeScreen.MainScreen.route) {
                    // Clears all previous destinations up to (and optionally including) the specified destination
                    popUpTo(FirstTimeScreen.FirstScreen.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

@Composable
fun ContinueText(modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.continue_text_1),
            style = Typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        AnnotatedClickableText()
    }
}

@Composable
fun ContinueButton(modifier: Modifier, onClick: () -> Unit) {
    FilledIconButton(modifier = modifier, onClick = { onClick() }) {
        Text(text = "Continue")
    }
}

@Composable
fun AnnotatedClickableText() {
    val annotatedText = buildAnnotatedString {
        // We attach this *TERMS* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = "TERMS", annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.25.sp,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(text = stringResource(id = R.string.continue_text_2))
        }
        pop()

        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.25.sp
            )
        ) {
            append(text = stringResource(id = R.string.continue_text_3))
        }

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = "POLICY", annotation = "https://developer.android.com/jetpack/compose/text"
        )
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.25.sp,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(text = stringResource(id = R.string.continue_text_4))
        }
        pop()
    }

    val uriHandler = LocalUriHandler.current
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            // We check if there is an annotation (TERMS) attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = "TERMS", start = offset, end = offset
            ).firstOrNull()?.let { annotation ->
                // If yes, we log its value
                Log.d("Clicked POLICY", annotation.item)
                uriHandler.openUri(annotation.item)
            }

            // We check if there is an annotation (POLICY) attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = "POLICY", start = offset, end = offset
            ).firstOrNull()?.let { annotation ->
                // If yes, we log its value
                Log.d("Clicked POLICY", annotation.item)
                uriHandler.openUri(annotation.item)
            }
        }
    )
}

@Preview(
    showBackground = true, name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showBackground = true, name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    name = "Day mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)
@Composable
fun FirstScreenPreview() {
    //FirstPage()
}