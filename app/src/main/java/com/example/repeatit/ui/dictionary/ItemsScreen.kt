package com.example.repeatit.ui.dictionary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.repeatit.R
import com.example.repeatit.data.entities.Item
import com.example.repeatit.ui.AppViewModelProvider


@Composable
fun ItemsScreen(
    viewModel: ItemsViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navHostController: NavHostController
) {
    val itemUiState by viewModel.itemsUiState.collectAsState()
    ListWithSearch(
        list = itemUiState.itemsList,
        navHostController = navHostController,
        stringResource(R.string.no_items),
        onItemClick = {}
    )
}


@Composable
fun ItemCard(item: Item, modifier: Modifier = Modifier) {
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface
    ),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(size = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        ) {
        Column(modifier = modifier.padding(vertical = 5.dp, horizontal = 5.dp)) {
            Text(
                text = item.firstValue,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(text = item.secondValue)
        }
    }
}