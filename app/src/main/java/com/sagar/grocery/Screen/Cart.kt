package com.sagar.grocery.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.grocery.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Cart() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar()
        Divider()
        SelectAllCheckBox()
        CartList()
    }

}

@Composable
fun CartList() {
    LazyColumn {
        item {
            CartItem()
        }

        item {
            CartItem()
        }

        item {
            CartItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItem() {

    var checkedState by rememberSaveable { mutableStateOf(false) }
    var count by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it }
            )

            Image(
                painter = painterResource(id = R.drawable.item_lettuce),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                Text(text = "iceberg lettuce")

                Text(text = "$12.2 kg")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {

                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                       // tint = if (isFavorite) Color.Red else Color.Gray
                    )
                    Text(text = /*if (isFavorite) "Favorited" else*/ "Notes")
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "remove",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = "decrease",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { if (count > 0) count-- }
                )

                Text(
                    text = count.toString(),
                    color = Color.Black,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center
                )

                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "increase",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { count++ }
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Divider(modifier = Modifier.padding(horizontal = 15.dp))
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Cart",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "fav"
            )
        }
    }
}

@Composable
fun SelectAllCheckBox() {

    var checkedState by rememberSaveable { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = it }
        )

        Text(
            text = "Select All",
            modifier = Modifier.padding(start = 5.dp)
        )
    }

}
