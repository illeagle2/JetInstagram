package com.vipulasri.jetinstagram.ui.favorites

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toDrawable
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.theme.JetInstagramTheme

class favoriteScreen {
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text("Search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun FavoritesElement(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int,
) {
    Row (
        verticalAlignment =  Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(),
    ){
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
        Spacer(modifier.padding(18.dp))
        Column {
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.paddingFromBaseline(
                    top = 24.dp, bottom = 8.dp
                )
            )
            Text(
                text = "name",
                style = MaterialTheme.typography.body2

            )
        }
        Spacer(Modifier.weight(1f))
        Button(
            modifier = Modifier
                .width(80.dp),

            onClick = { /*TODO*/ },
        ) {
            Text(text = "Add")
        }

    }
}

@Composable
private fun ToolsBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(painter = painterResource(R.drawable.baseline_close_24), contentDescription = "back")
        Text(text = "Favorites")
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add")

    }
}


@Composable
fun FavoriteScreen(){
    Column {
        ToolsBar()
        Spacer(modifier = Modifier.height(16.dp))
        //hint compose here
        Text(
            text = stringResource(id = R.string.fav_hint),
            textAlign = TextAlign.Center,

        )
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ){
            items(favoritesData) {item->
                FavoritesElement(drawable = item.drawable, text = item.text )
            }
        }
    }

}

private val favoritesData = listOf(
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name,
    R.drawable.ic_filled_home to R.string.app_name
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    JetInstagramTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPreview() {
    JetInstagramTheme{
        FavoritesElement(
            modifier = Modifier.padding(8.dp),
            drawable = R.drawable.ic_filled_home,
            text = R.string.app_name
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    JetInstagramTheme {
        FavoriteScreen()
    }
}