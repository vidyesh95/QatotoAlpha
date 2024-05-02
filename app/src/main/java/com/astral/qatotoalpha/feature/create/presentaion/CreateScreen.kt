package com.astral.qatotoalpha.feature.create.presentaion

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddBusiness
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.PostAdd
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Stream
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.auth.presentation.signin.UserData
import com.astral.qatotoalpha.graphs.Graph
import com.astral.qatotoalpha.ui.theme.RobotoSerifFontFamily

@Composable
fun CreateScreen(navController: NavController, userData: UserData?) {
    CreatePage(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePage(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .nestedScroll(connection = scrollBehavior.nestedScrollConnection), topBar = {
        TopAppBar(title = {
            Text(
                text = "Qatoto",
                style = MaterialTheme.typography.titleLarge,
                fontFamily = RobotoSerifFontFamily,
                fontWeight = FontWeight.Normal
            )
        }, actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.NotificationsNone,
                    contentDescription = "No Notifications"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(onClick = { navController.navigate(Graph.PROFILE_GRAPH) }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Account"
                )
            }
        }, scrollBehavior = scrollBehavior
        )
    }) { innerPadding ->
        CreateScreenContent(innerPadding)
    }
}

@Composable
fun CreateScreenContent(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .width(328.dp)
                .height(328.dp),
            painter = painterResource(id = R.drawable.illustration_container),
            contentDescription = "Create Illustration",
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(onClick = { /*TODO*/ })
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Outlined.FileUpload,
                contentDescription = stringResource(id = R.string.upload_video)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f),
                text = stringResource(id = R.string.upload_video),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                maxLines = 1,
                softWrap = true,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.upload_video),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(onClick = { /*TODO*/ })
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Outlined.AddBusiness,
                contentDescription = stringResource(id = R.string.create_store_listing)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f),
                text = "Create Store Listing",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                maxLines = 1,
                softWrap = true,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.create_store_listing),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(onClick = { /*TODO*/ })
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Outlined.Stream,
                contentDescription = stringResource(id = R.string.go_live)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f),
                text = "Go Live",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                maxLines = 1,
                softWrap = true,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.go_live),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(onClick = { /*TODO*/ })
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Outlined.VideoCall,
                contentDescription = stringResource(id = R.string.create_short)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f),
                text = "Create Short",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                maxLines = 1,
                softWrap = true,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.create_short),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(onClick = { /*TODO*/ })
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.outline_swords_24),
                contentDescription = stringResource(id = R.string.live_wars)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f),
                text = "Live Wars",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                maxLines = 1,
                softWrap = true,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.live_wars),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(onClick = { /*TODO*/ })
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Outlined.PostAdd,
                contentDescription = stringResource(id = R.string.create_community_post)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f),
                text = stringResource(id = R.string.create_community_post),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                maxLines = 1,
                softWrap = true,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.create_community_post),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showBackground = true,
    name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    name = "Day mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)
@Composable
fun CreateScreenPreview() {
    val navController = rememberNavController()
    CreatePage(navController = navController)
}