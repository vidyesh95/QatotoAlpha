package com.astral.qatotoalpha.feature.home.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.astral.qatotoalpha.feature.home.data.repository.VideoRepository
import com.astral.qatotoalpha.feature.home.domain.model.VideoModel
import com.astral.qatotoalpha.feature.shorts.data.repository.ShortsRepository
import com.astral.qatotoalpha.feature.shorts.domain.model.ShortsModel
import com.astral.qatotoalpha.ui.theme.RobotoSerifFontFamily

@Composable
fun HomeScreen() {
    HomePage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val viewModel = viewModel<HomeScreenViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeScreenViewModel(
                    tintCo = "0xFF00FF00"
                ) as T
            }
        }
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(connection = scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Qatoto",
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = RobotoSerifFontFamily,
                        fontWeight = FontWeight.Normal
                    )
                },
                actions = {
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
                    IconButton(
                        onClick = {
                            viewModel.onTintColorChanged()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = "Account",
                            tint = viewModel.tintColor
                            //tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        HomeScreenContent(innerPadding)
    }
}

@Composable
fun HomeScreenContent(innerPadding: PaddingValues) {
    val videoRepository = VideoRepository()
    val videoData = videoRepository.getAllData()

    val shortsRepository = ShortsRepository()
    val shortsData = shortsRepository.getAllData()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(
            items = videoData,
            key = { index, item ->
                "${index}-${item.videoId}"
            }
        ) { index, item ->
            if (index == 1) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = "Shorts",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 0.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        )
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(
                            items = shortsData.take(4),
                            key = {
                                it.shortsId
                            }
                        ) { item ->
                            if (item.isLive) {
                                ShortsContainerLive(shortsModel = item)
                            } else {
                                ShortsContainer(shortsModel = item)
                            }
                        }
                    }
                    HorizontalDivider(modifier = Modifier.padding(all = 16.dp))
                }
            }
            if (item.isLive) {
                VideoContainerLive(videoModel = item)
            } else {
                VideoContainer(videoModel = item)
            }
        }
    }
}

@Composable
fun ShortsContainer(shortsModel: ShortsModel) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .aspectRatio(9f / 16f)
            .clip(shape = MaterialTheme.shapes.small),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = shortsModel.shortsThumbnail),
            contentDescription = "Shorts Thumbnail",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.25f))
        )

        Icon(
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .padding(top = 6.dp)
                .size(24.dp),
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More Options",
            tint = Color.White,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomStart)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = shortsModel.shortsTitle,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                softWrap = true,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = shortsModel.shortsViews,
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = "views",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
fun ShortsContainerLive(shortsModel: ShortsModel) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .aspectRatio(9f / 16f)
            .clip(shape = MaterialTheme.shapes.small),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = shortsModel.shortsThumbnail),
            contentDescription = "Shorts Thumbnail",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.25f))
        )

        Icon(
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .padding(top = 6.dp)
                .size(24.dp),
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More Options",
            tint = Color.White,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomStart)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = shortsModel.shortsTitle,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                softWrap = true,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = shortsModel.shortsWatching,
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = "watching",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VideoContainer(videoModel: VideoModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
            painter = painterResource(id = videoModel.videoThumbnail),
            contentDescription = "Video Thumbnail"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .width(36.dp)
                    .aspectRatio(ratio = 1f / 1f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    )
                    .clip(shape = CircleShape),
                painter = painterResource(id = videoModel.profileImage),
                contentDescription = "Video Thumbnail",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f)
                    .padding(top = 12.dp),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = videoModel.videoTitle,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 2,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                )
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = videoModel.channelName,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "•",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = videoModel.videoViews,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "views",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "•",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = videoModel.videoDuration,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "ago",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .padding(end = 14.dp, top = 14.dp)
                    .width(14.dp)
                    .height(14.dp),
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        HorizontalDivider(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VideoContainerLive(videoModel: VideoModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
            painter = painterResource(id = videoModel.videoThumbnail),
            contentDescription = "Video Thumbnail"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .width(36.dp)
                    .aspectRatio(ratio = 1f / 1f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    )
                    .clip(shape = CircleShape),
                painter = painterResource(id = videoModel.profileImage),
                contentDescription = "Video Thumbnail",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f)
                    .padding(top = 12.dp),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = videoModel.videoTitle,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 2,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                )
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = videoModel.channelName,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "•",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = videoModel.videoWatching,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "watching",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "•",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "live",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline,
                        maxLines = 1,
                        softWrap = true,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .padding(end = 14.dp, top = 14.dp)
                    .width(14.dp)
                    .height(14.dp),
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Options",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        HorizontalDivider(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp))
    }
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
fun HomeScreenPreview() {
    HomePage()
}
