package com.example.repeatit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repeatit.db.Theme
import com.example.repeatit.ui.theme.RepeatItTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepeatItTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ThemesPreview()
                }
            }
        }
    }
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
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp, disabledElevation = 3.dp),
//        border = BorderStroke(width = 0.dp, color = MaterialTheme.colorScheme.onSurface)


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
                        vertical = 7.dp,
                        horizontal = 12.dp
                    )
            )
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(value = "", onValueChange = {}, modifier = modifier)
}


@Preview(showBackground = true,)
@Composable
fun ThemesPreview() {
    RepeatItTheme {
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

        Surface(modifier = Modifier.fillMaxSize()) {
            ShowThemes(modifier = Modifier, themes=themes)
        }
    }
}
