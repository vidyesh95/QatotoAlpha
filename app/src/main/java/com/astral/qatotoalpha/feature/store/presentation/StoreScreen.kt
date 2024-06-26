package com.astral.qatotoalpha.feature.store.presentation

import android.content.res.Configuration
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DirectionsBoat
import androidx.compose.material.icons.outlined.Factory
import androidx.compose.material.icons.outlined.Forum
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.RequestQuote
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Shop
import androidx.compose.material.icons.outlined.ShoppingCart
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.astral.qatotoalpha.R
import com.astral.qatotoalpha.feature.auth.presentation.signin.UserData
import com.astral.qatotoalpha.feature.store.data.repository.ProductRepository
import com.astral.qatotoalpha.feature.store.data.repository.StorePathwayRepository
import com.astral.qatotoalpha.feature.store.data.repository.StoreScreenRepository
import com.astral.qatotoalpha.feature.store.domain.model.ProductModel
import com.astral.qatotoalpha.feature.store.domain.model.StorePathwayModel
import com.astral.qatotoalpha.feature.store.domain.model.StoreScreenModel
import com.astral.qatotoalpha.graphs.Graph
import com.astral.qatotoalpha.ui.theme.RobotoSerifFontFamily

@Composable
fun StoreScreen(navController: NavController, userData: UserData?) {
    StorePage(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StorePage(navController: NavController) {
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
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "Shopping Cart"
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
        StoreScreenContent(innerPadding)
    }
}

@Composable
fun LazyProductRowItem(product: ProductModel) {
    Column(
        modifier = Modifier
            .width(width = 140.dp)
            .wrapContentHeight()
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { /*TODO*/ }
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Image(
            modifier = Modifier
                .width(width = 140.dp)
                .aspectRatio(3f / 4f)
                .clip(shape = MaterialTheme.shapes.small),
            painter = painterResource(id = product.productThumbnail),
            contentDescription = product.productTitle,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 32.dp),
            text = product.productTitle,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center,
            softWrap = true,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun LazyProductRow(item: StoreScreenModel) {
    val productRepository = ProductRepository()
    val productData = productRepository.getAllData()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 12.dp),
    ) {
        items(
            items = when (item.columnSort) {
                "whatsNew" -> productData.sortedBy { it.productRecentRank }
                "popular" -> productData.sortedBy { it.productPopularityRank }
                "forYou" -> productData.sortedBy { it.productRank }
                "trending" -> productData.sortedBy { it.productTrendingRank }
                else -> productData
            }.take(6),
            key = {
                it.productId
            }
        ) { item ->
            LazyProductRowItem(product = item)
        }
    }
}

@Composable
fun LazyStoreRow(item: StoreScreenModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 4.dp)
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
                text = item.columnTitle,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "More ${item.columnTitle}",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        LazyProductRow(item = item)
    }
}


@Composable
fun Starter() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Carousel()
        Categories()
        Pathways()
        BusinessCards()
    }
}

@Composable
fun StoreScreenContent(innerPadding: PaddingValues) {
    val storeScreenRepository = StoreScreenRepository()
    val storeScreenData = storeScreenRepository.getAllData()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        itemsIndexed(
            items = storeScreenData,
            key = { index, item ->
                "${index}-${item.columnId}"
            }
        ) { index, item ->
            if (index == 0) {
                Starter()
            }
            LazyStoreRow(item = item)
        }
    }
}

@Composable
fun Pathways() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp)
            .clickable { /*TODO*/ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Pathways\uD83D\uDCA1",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "More Recent Pathways",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        LazyStorePathwayRow()
    }
}

@Composable
fun LazyStorePathwayRow() {
    val storePathwayRepository = StorePathwayRepository()
    val storePathwayData = storePathwayRepository.getAllData()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 12.dp),
    ) {
        items(
            items = storePathwayData.sortedBy { it.storePathwayRank }.take(6),
            key = {
                it.storePathwayId
            }
        ) { item ->
            LazyStorePathwayRowItem(storePathway = item)
        }
    }
}

@Composable
fun LazyStorePathwayRowItem(storePathway: StorePathwayModel) {
    Column(
        modifier = Modifier
            .width(width = 140.dp)
            .wrapContentHeight()
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { /*TODO*/ }
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Image(
            modifier = Modifier
                .width(width = 140.dp)
                .aspectRatio(3f / 4f)
                .clip(shape = MaterialTheme.shapes.small),
            painter = painterResource(id = storePathway.storePathwayThumbnail),
            contentDescription = storePathway.storePathwayTitle,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 32.dp),
            text = storePathway.storePathwayTitle,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center,
            softWrap = true,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun Carousel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = Color.Black)
            .clickable { /*TODO*/ }
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
            painter = painterResource(id = R.drawable.store_banner_1),
            contentDescription = "Carousel",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Categories() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 4.dp)
            .clickable { /*TODO*/ },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categories",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "More Recent Categories",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.small)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f / 1f)
                        .clip(shape = MaterialTheme.shapes.extraSmall),
                    painter = painterResource(id = R.drawable.clothes),
                    contentDescription = "Clothes"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Clothes",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.small)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f / 1f)
                        .clip(shape = MaterialTheme.shapes.extraSmall),
                    painter = painterResource(id = R.drawable.furniture),
                    contentDescription = "Furniture"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Furniture",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.small)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f / 1f)
                        .clip(shape = MaterialTheme.shapes.extraSmall),
                    painter = painterResource(id = R.drawable.accessories),
                    contentDescription = "Accessories"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Accessories",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.small)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f / 1f)
                        .clip(shape = MaterialTheme.shapes.extraSmall),
                    painter = painterResource(id = R.drawable.beauty),
                    contentDescription = "Beauty"
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Beauty",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun BusinessCards() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Shop,
                        contentDescription = "Live Sale",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Live Sale",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.RequestQuote,
                        contentDescription = "Request for Quotation",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Request for Quotation",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.DirectionsBoat,
                        contentDescription = "Logistic Services",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Logistic Services",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Factory,
                        contentDescription = "Factories Worldwide",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Factories Worldwide",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Forum,
                        contentDescription = "Business Forum",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Business Forum",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .clickable { /*TODO*/ }
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Group,
                        contentDescription = "Find Cofounder",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "Find Cofounder",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
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
)*/
@Preview(
    name = "Day mode - Tablet",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_c"
)
/*@PreviewScreenSizes
@PreviewFontScale
@PreviewLightDark
@PreviewDynamicColors*/
@Composable
fun StoreScreenPreview() {
    val navController = rememberNavController()
    StorePage(navController = navController)
}