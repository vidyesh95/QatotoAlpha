package com.astral.qatotoalpha.feature.shorts.presentation

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.GroupWork
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.shorts.data.repository.ShortsRepository
import com.astral.qatotoalpha.feature.shorts.domain.model.ShortsModel

@Composable
fun ShortsScreen() {
    ShortsPage()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortsPage() {
    val shortsRepository = ShortsRepository()
    val shortsData = shortsRepository.getAllData()
    val pagerState = rememberPagerState(pageCount = { shortsData.size })

    LaunchedEffect(pagerState) {
        // Collect from the a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            // Do something with each page change, for example:
            // viewModel.sendPageSelectedEvent(page)
            Log.d("Page change", "Page changed to $page")
        }
    }

    VerticalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
        key = { item ->
            item
        },
    ) { currentPage ->
        ShortsItem(shortsModel = shortsData[currentPage])
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortsItem(shortsModel: ShortsModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(id = shortsModel.shortsThumbnail),
            contentDescription = "Video Thumbnail",
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            // Left side
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f)
                    .padding(all = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Shop banner
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(shape = MaterialTheme.shapes.extraSmall)
                        .background(color = Color.Black.copy(alpha = 0.5f))
                        .clickable { /*TODO*/ }
                        .padding(all = 4.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(size = 16.dp)
                            .clip(shape = RoundedCornerShape(size = 2.dp))
                            .background(color = Color(0xFFFF8038))
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(size = 14.dp)
                                .align(Alignment.Center),
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Shopping",
                            tint = Color.White
                        )
                    }

                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        Row(
                            modifier = Modifier
                                .wrapContentSize()
                        ) {
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "Shop",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White,
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "|",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White,
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "Great book",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White,
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        Row(
                            modifier = Modifier
                                .wrapContentSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "Shopping evaluation",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White.copy(alpha = 0.8f),
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "6009",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White.copy(alpha = 0.8f),
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "|",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White.copy(alpha = 0.8f),
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "Sold ",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White.copy(alpha = 0.8f),
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                modifier = Modifier
                                    .wrapContentSize(),
                                text = "9.7k",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Start,
                                color = Color.White.copy(alpha = 0.8f),
                                softWrap = true,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                    }
                }

                Box(
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .blur(radius = 2.dp)
                            .offset(x = 0.dp, y = 1.dp),
                        text = "@username",
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Start,
                        color = Color.Black.copy(alpha = 0.5f),
                        softWrap = true,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = "@username",
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        softWrap = true,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Display number of co-creators
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(shape = MaterialTheme.shapes.extraSmall)
                        .background(color = Color.Black.copy(alpha = 0.5f))
                        .padding(all = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(size = 12.dp),
                        imageVector = Icons.Outlined.GroupWork,
                        contentDescription = "Group Work",
                        tint = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentSize(),
                        text = "Co-created by",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentSize(),
                        text = "6",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        softWrap = true,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentSize(),
                        text = "people",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                }

                // Co-creators profile images
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(size = 24.dp)
                            .clip(shape = CircleShape)
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                            .padding(all = 1.dp),
                        painter = painterResource(id = R.drawable.profile_image_1),
                        contentDescription = "profile image",
                    )
                    Image(
                        modifier = Modifier
                            .size(size = 24.dp)
                            .clip(shape = CircleShape)
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                            .padding(all = 1.dp),
                        painter = painterResource(id = R.drawable.profile_image_2),
                        contentDescription = "profile image",
                    )
                    Image(
                        modifier = Modifier
                            .size(size = 24.dp)
                            .clip(shape = CircleShape)
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                            .padding(all = 1.dp),
                        painter = painterResource(id = R.drawable.profile_image_3),
                        contentDescription = "profile image",
                    )
                    Icon(
                        modifier = Modifier
                            .size(size = 24.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color.Black.copy(alpha = 0.5f))
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                            .padding(all = 1.dp),
                        imageVector = Icons.Filled.MoreHoriz,
                        contentDescription = "more profile images",
                        tint = Color.White
                    )
                }

                // Video description
                Box(
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .blur(radius = 2.dp)
                            .offset(x = 0.dp, y = 1.dp),
                        text = "Macron hosts Sunak at Elysee Palace Sunak: It's new start.",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start,
                        color = Color.Black.copy(alpha = 0.5f),
                        softWrap = true,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = shortsModel.shortsTitle,
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        softWrap = true,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Video tags
                Box(
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .blur(radius = 2.dp)
                            .offset(x = 0.dp, y = 1.dp),
                        text = "#news",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start,
                        color = Color.Black.copy(alpha = 0.5f),
                        softWrap = true,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        text = "#news",
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        softWrap = true,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    modifier = Modifier.wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Box(modifier = Modifier.wrapContentSize()) {
                        Icon(
                            modifier = Modifier
                                .size(size = 14.dp)
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            imageVector = Icons.Filled.MusicNote,
                            contentDescription = "Soundtrack",
                            tint = Color.Black.copy(alpha = 0.5f)
                        )
                        Icon(
                            modifier = Modifier.size(size = 14.dp),
                            imageVector = Icons.Filled.MusicNote,
                            contentDescription = "Soundtrack",
                            tint = Color.White
                        )
                    }

                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp)
                                .basicMarquee(
                                    iterations = Int.MAX_VALUE,
                                    delayMillis = 0
                                ),
                            text = "original soundtrack - Created by Quanmin Producer @user_name",
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Start,
                            color = Color.Black.copy(alpha = 0.5f),
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .basicMarquee(
                                    iterations = Int.MAX_VALUE,
                                    delayMillis = 0
                                ),
                            text = "original soundtrack - Created by Quanmin Producer @user_name",
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Start,
                            color = Color.White,
                            maxLines = 1,
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(all = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(width = 40.dp)
                        .height(height = 48.dp)
                ) {
                    IconButton(
                        modifier = Modifier
                            .size(40.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(shape = CircleShape)
                                .border(
                                    width = 2.dp,
                                    color = Color.White,
                                    shape = CircleShape
                                )
                                .padding(all = 2.dp),
                            painter = painterResource(
                                id = shortsModel.profileImage
                            ),
                            contentDescription = "Profile Image",
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(size = 16.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xFFFE2C55))
                            .align(Alignment.BottomCenter)
                            .clickable { /*TODO*/ },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(size = 12.dp),
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Focus on user",
                            tint = Color.White
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(
                            indication = rememberRipple(bounded = false, radius = 26.dp),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            /*TODO*/
                        },
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp)
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favorite",
                            tint = Color.Black.copy(alpha = 0.5f)
                        )

                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp),
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favorite",
                            tint = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight()
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            text = "923M",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Black.copy(alpha = 0.5f),
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight(),
                            text = "923M",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(
                            indication = rememberRipple(bounded = false, radius = 26.dp),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            /*TODO*/
                        },
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp)
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            imageVector = Icons.AutoMirrored.Filled.Comment,
                            contentDescription = "Comment",
                            tint = Color.Black.copy(alpha = 0.5f)
                        )
                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp),
                            imageVector = Icons.AutoMirrored.Filled.Comment,
                            contentDescription = "Comment",
                            tint = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight()
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            text = "414",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Black.copy(alpha = 0.5f),
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight(),
                            text = "414",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(
                            indication = rememberRipple(bounded = false, radius = 26.dp),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            /*TODO*/
                        },
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp)
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            imageVector = Icons.Filled.Bookmark,
                            contentDescription = "Bookmark",
                            tint = Color.Black.copy(alpha = 0.5f)
                        )
                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp),
                            imageVector = Icons.Filled.Bookmark,
                            contentDescription = "Bookmark",
                            tint = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight()
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            text = "1.1K",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Black.copy(alpha = 0.5f),
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight(),
                            text = "1.1K",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(
                            indication = rememberRipple(bounded = false, radius = 26.dp),
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            /*TODO*/
                        },
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp)
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            tint = Color.Black.copy(alpha = 0.5f)
                        )
                        Icon(
                            modifier = Modifier
                                .size(size = 24.dp),
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            tint = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier.wrapContentSize()
                    ) {
                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight()
                                .blur(radius = 2.dp)
                                .offset(x = 0.dp, y = 1.dp),
                            text = "3696",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Black.copy(alpha = 0.5f),
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier
                                .width(width = 40.dp)
                                .wrapContentHeight(),
                            text = "3696",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White,
                            softWrap = true,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(size = 37.dp)
                        .clip(shape = CircleShape)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color.Black,
                                    Color(0xFF555555),
                                    Color.Black
                                ),
                                start = Offset(37f, 0f),
                                end = Offset(0f, 37f)
                            )
                        )
                        .clickable { /*TODO*/ },
                ) {
                    Image(
                        modifier = Modifier
                            .size(size = 22.dp)
                            .clip(shape = CircleShape)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.profile_image_4),
                        contentDescription = "Soundtrack"
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true, name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
/*@Preview(
    showBackground = true, name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    name = "Day mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)*/
@Composable
fun ShortsScreenPreview() {
    ShortsPage()
}