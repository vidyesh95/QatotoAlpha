package com.astral.qatotoalpha.feature.anime.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Search
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.anime.data.repository.AnimeRepository
import com.astral.qatotoalpha.feature.anime.data.repository.AnimeScreenRepository
import com.astral.qatotoalpha.feature.anime.domain.model.AnimeModel
import com.astral.qatotoalpha.feature.anime.domain.model.AnimeScreenModel
import com.astral.qatotoalpha.feature.auth.presentation.signin.UserData
import com.astral.qatotoalpha.graphs.Graph
import com.astral.qatotoalpha.ui.theme.RobotoSerifFontFamily

@Composable
fun AnimeScreen(navController: NavController, userData: UserData?) {
    AnimePage(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimePage(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
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
                    IconButton(onClick = { navController.navigate(Graph.PROFILE_GRAPH) }) {
                        Icon(
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = "Account"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        AnimeScreenContent(innerPadding)
    }
}

@Composable
fun AnimeHero() {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .aspectRatio(ratio = 16f / 9f)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = Color.Black)
            .clickable { /*TODO*/ }
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 16f / 9f),
            painter = painterResource(id = R.drawable.anime_hero_thumbnail),
            contentDescription = "Anime Video Thumbnail",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Black.copy(alpha = 0.25f),
                            Color.Transparent,
                            Color.Transparent,
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.75f)
                        )
                    )
                )
        )
        IconButton(
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .padding(top = 8.dp, end = 6.dp)
                .size(24.dp),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.AutoMirrored.Filled.VolumeOff,
                contentDescription = "Volume Off",
                tint = Color.White,
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(vertical = 8.dp, horizontal = 8.dp),
            text = "A Record Of Mortal's Journey To Immortality: " +
                    "Immortal Han Li's Adventure with cyan bottle",
            color = Color.White,
            style = MaterialTheme.typography.titleSmall,
            softWrap = true,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun IconButtonRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                vertical = 8.dp,
                horizontal = 16.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .clip(shape = MaterialTheme.shapes.small)
                .clickable { /*TODO*/ }
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.genre),
                contentDescription = "Genre"
            )
            Text(text = "Genre", style = MaterialTheme.typography.labelLarge)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .clip(shape = MaterialTheme.shapes.small)
                .clickable { /*TODO*/ }
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.daily),
                contentDescription = "Daily"
            )
            Text(text = "Daily", style = MaterialTheme.typography.labelLarge)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .clip(shape = MaterialTheme.shapes.small)
                .clickable { /*TODO*/ }
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.favorite),
                contentDescription = "Favorite"
            )
            Text(text = "Favorite", style = MaterialTheme.typography.labelLarge)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .clip(shape = MaterialTheme.shapes.small)
                .clickable { /*TODO*/ }
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.ranking),
                contentDescription = "Ranking"
            )
            Text(text = "Ranking", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
fun LazyAnimeRowItem(animeModel: AnimeModel) {
    Column(
        modifier = Modifier
            .width(width = 158.dp)
            .clip(shape = MaterialTheme.shapes.extraSmall)
            .clickable { /*TODO*/ },
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 16f / 9f)
                .clip(shape = MaterialTheme.shapes.extraSmall),
            painter = painterResource(id = animeModel.videoThumbnail),
            contentDescription = "Recent Video"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 32.dp),
            text = animeModel.videoTitle,
            style = MaterialTheme.typography.labelSmall,
            softWrap = true,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun LazyAnimeRow(item: AnimeScreenModel) {
    val animeRepository = AnimeRepository()
    val animeData = animeRepository.getAllData()
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(
            items = when (item.rowSort) {
                "recentEpisodeRank" -> animeData.sortedBy { it.recentEpisodeRank }
                "recommendedForYouRank" -> animeData.sortedBy { it.recommendedForYouRank }
                "completedSeriesRank" -> animeData.sortedBy { it.completedSeriesRank }
                "trendingRank" -> animeData.sortedBy { it.trendingRank }
                "newArrivalRank" -> animeData.sortedBy { it.newArrivalRank }
                else -> animeData
            }.take(6),
            key = {
                it.videoId
            }
        ) { item ->
            LazyAnimeRowItem(animeModel = item)
        }
    }
}

@Composable
fun LazyAnimeColumnItem(item: AnimeScreenModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { /*TODO*/ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.rowTitle,
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "More Recent Episode"
            )
        }
        LazyAnimeRow(item = item)
    }
}

@Composable
fun AnimeScreenContent(innerPadding: PaddingValues) {
    val animeScreenRepository = AnimeScreenRepository()
    val animeScreenData = animeScreenRepository.getAllData()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(
            items = animeScreenData,
            key = { index, item ->
                "${index}-${item.rowId}"
            }
        ) { index, item ->
            if (index == 0) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    AnimeHero()
                    IconButtonRow()
                }
            }
            LazyAnimeColumnItem(item = item)
        }
    }
}


/*@Preview(
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
)*/
//@PreviewScreenSizes
//@PreviewFontScale
@PreviewLightDark
//@PreviewDynamicColors
@Composable
fun AnimeScreenPreview() {
    val navController = rememberNavController()
    AnimePage(navController = navController)
}