package com.sagar.grocery.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.grocery.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Home() {
    Box(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.main_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            contentScale = ContentScale.FillWidth
        )

        Column {
            AppBar()
            ScreenContent()
        }
    }
}

@Composable
fun ScreenContent() {

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Header()
        Spacer(modifier = Modifier.height(20.dp))
        Promotion()
        Spacer(modifier = Modifier.height(25.dp))
        CategorySection()
        Spacer(modifier = Modifier.height(25.dp))
        BestSellerSection()
    }

}

@Composable
fun BestSellerSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Best Sellers", style = MaterialTheme.typography.bodyLarge)
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "More", color = Color.Green)
        }
    }

    LazyRow(
        // modifier = Modifier.height(160.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_lettuce),
                title = "Iceberg Lettuce",
                price = "1.99",
                discountPercent = 10
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_apple),
                title = "Apple",
                price = "2.64",
                discountPercent = 5
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.item_meat),
                title = "Meat",
                price = "4.76",
                discountPercent = 20
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestSellerItem(
    imagePainter: Painter,
    title: String,
    price: String,
    discountPercent: Int
) {

    Column(
        modifier = Modifier.width(160.dp),

        ) {
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold
            )

            Row {
                Text(
                    text = "$${price}",
                    textDecoration = if (discountPercent > 0) TextDecoration.LineThrough else TextDecoration.None,
                    color = if (discountPercent > 0) Color.Gray else Color.Black
                )
                if (discountPercent > 0) {
                    Text(
                        text = "[$discountPercent%]"
                    )
                }
            }
        }
    }
}

@Composable
fun CategorySection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Category", style = MaterialTheme.typography.bodyLarge)
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "More", color = Color.Green)
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryButton(
            text = "Fruits",
            icon = painterResource(id = R.drawable.ic_fruit),
            backgroundColor = Color(0xffFEF4E7)
        )
        CategoryButton(
            text = "Vegetables",
            icon = painterResource(id = R.drawable.ic_veg),
            backgroundColor = Color(0xffF6FBF3)
        )
        CategoryButton(
            text = "Dairy",
            icon = painterResource(id = R.drawable.ic_dairy),
            backgroundColor = Color(0xffFFFBF3)
        )
        CategoryButton(
            text = "Meats",
            icon = painterResource(id = R.drawable.ic_meat),
            backgroundColor = Color(0xffF6E6E9)
        )
    }
}

@Composable
fun CategoryButton(text: String, icon: Painter, backgroundColor: Color) {
    Column(
        modifier = Modifier.height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ) {
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}

@Composable
fun Promotion() {
    LazyRow(
        modifier = Modifier
            .height(160.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.img),
                title = "Fruit",
                subtitle = "Start @",
                header = "$1"
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.img),
                title = "Fruit",
                subtitle = "Start @",
                header = "$1"
            )
        }
        item {
            PromotionItem(
                imagePainter = painterResource(id = R.drawable.img),
                title = "Fruit",
                subtitle = "Start @",
                header = "$1"
            )
        }
    }
}

@Composable
fun PromotionItem(
    title: String = "",
    subtitle: String = "",
    header: String = "",
    imagePainter: Painter
) {
    Card(
        modifier = Modifier
            .width(300.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row {
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, fontSize = 14.sp, color = Color.White)
                Text(
                    text = subtitle,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = header,
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                alignment = Alignment.CenterEnd,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun Header() {
    Card(
        modifier = Modifier
            .height(64.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            QRscan()

            verticalDivider()

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_money),
                    contentDescription = null,
                    tint = Color.Green
                )
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = "$100",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Text(
                        text = "Top Up",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 12.sp
                    )
                }
            }

            verticalDivider()

            Row(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin),
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Column(Modifier.padding(8.dp)) {
                    Text(text = "$50", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Points", color = Color.Black, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun verticalDivider() {
    Divider(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}

@Composable
fun QRscan() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1f)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {

    var searchText by rememberSaveable {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            value = searchText,
            onValueChange = { searchText = it },
            singleLine = true,
            label = {
                Text(
                    text = "Search Fruit, Vegetables, etc",
                    overflow = TextOverflow.Ellipsis
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White,
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "search")
            },
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                tint = Color.White
            )
        }

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}
