package com.example.repeatit.ui.dictionary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repeatit.R
import com.example.repeatit.db.Theme

@Composable
fun DictScreen() {
    val themes = arrayOf(
        Theme(1, "Даты"),
        Theme(2, "Английский"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(3, "Формулы"),
        Theme(4, "Другое"))

    ListWithSearch(themes = themes)
}


@Composable
fun ThemeCard(theme: Theme, modifier: Modifier = Modifier) {
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface
    ),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(size = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),


        ) {
        Text(
            text = theme.themeName,
            modifier = modifier.padding(vertical = 5.dp, horizontal = 5.dp)
        )
    }
}


@Composable
fun ShowThemes(
    modifier: Modifier = Modifier,
    themes: Array<Theme> = arrayOf()) {

    LazyColumn(modifier = modifier) {
        items(items = themes) { theme ->
            ThemeCard(
                theme = theme,
                modifier = modifier
                    .padding(
                        horizontal = 12.dp,
                        vertical = 5.dp
                    )
            )
        }
    }

}

@Preview
@Composable
fun DictScreenPreview() {
    DictScreen()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = { Text(stringResource(R.string.placeholder_search)) })
}


@Composable
fun ListWithSearch(themes: Array<Theme>) {
    Column{
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        ShowThemes(modifier = Modifier, themes = themes)
    }
}