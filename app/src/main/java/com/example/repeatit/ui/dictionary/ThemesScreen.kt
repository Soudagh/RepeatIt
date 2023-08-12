package com.example.repeatit.ui.dictionary

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.repeatit.R
import com.example.repeatit.data.entities.Item
import com.example.repeatit.data.entities.Theme
import com.example.repeatit.ui.AppViewModelProvider
import com.example.repeatit.ui.navigation.Graph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemesScreen(
    viewModel: DictViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navController: NavHostController = rememberNavController(),
    navigateToItem: (Int) -> Unit,
) {
    val dictUiState by viewModel.dictUiState.collectAsState()
    Scaffold {
        ListWithSearch(
            list = dictUiState.themeList,
            onItemClick = navigateToItem,
            navHostController = navController,
            emptyString = stringResource(id = R.string.no_themes))
    }
}


@Composable
fun ThemeCard(
    theme: Theme,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
    navHostController: NavHostController
) {
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface
    ),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onItemClick(theme.id)
            },
        shape = RoundedCornerShape(size = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        ) {
        Column(modifier = modifier.padding(vertical = 5.dp, horizontal = 5.dp)) {
            Text(
                text = theme.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = Bold
            )
            Text(text = theme.description)
        }
    }

}


@Composable
fun ShowCards(
    modifier: Modifier = Modifier,
    list: List<Any> = listOf(),
    navHostController: NavHostController,
    onItemClick: (Int) -> Unit,
    emptyString: String
) {

    if (list.isEmpty()) {
        Text(
            text = emptyString,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    } else {
        LazyColumn(modifier = modifier) {
            items(items = list) { item ->
                when(item) {
                    is Item -> ItemCard(
                        item = item,
                        modifier = modifier
                            .padding(
                                horizontal = 12.dp,
                                vertical = 5.dp
                            )
                    )
                    is Theme -> ThemeCard(
                        theme = item,
                        modifier = modifier
                            .padding(
                                horizontal = 12.dp,
                                vertical = 5.dp
                            ),
                        onItemClick = onItemClick,
                        navHostController = navHostController
                    )
                }

            }
        }
    }
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        }
    )
}


@Composable
fun ListWithSearch(
    list: List<Any>,
    navHostController: NavHostController,
    emptyString: String,
    onItemClick: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        ShowCards(
            modifier = Modifier,
            list = list,
            navHostController = navHostController,
            onItemClick = onItemClick,
            emptyString = emptyString
        )
    }
}
