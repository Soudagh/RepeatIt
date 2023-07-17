package com.example.repeatit.ui.dictionary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.repeatit.R
import com.example.repeatit.ui.AppViewModelProvider
import com.example.repeatit.ui.navigation.ModificationScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeEntryScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    viewModel: ThemeEntryViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    Scaffold(
        topBar = {
            DictTopAppBar(
                title = stringResource(id = ModificationScreen.Addition.titleRes),
                canNavigateBack = canNavigateBack,
                navigateUp = onNavigateUp
            )
        }
    ) { innerPadding ->
        ThemeEntryBody(
            themeUiState = viewModel.themeUiState,
            onThemeValueChange = viewModel::updateUiState,
            onSaveClick = { /*TODO*/ },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth())
        
    }
}


@Composable
fun ThemeEntryBody(
    themeUiState: ThemeUiState,
    onThemeValueChange: (ThemeDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        ThemeInputForm(
            themeDetails = themeUiState.themeDetails,
            onValueChange = onThemeValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = themeUiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.save_action))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeInputForm(
    themeDetails: ThemeDetails,
    modifier: Modifier = Modifier,
    onValueChange: (ThemeDetails) -> Unit = {},
    enabled: Boolean = true

) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = themeDetails.name,
            onValueChange = {onValueChange(themeDetails.copy(name = it))},
            label = { Text(stringResource(id = R.string.theme_name_req)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = themeDetails.description,
            onValueChange = { onValueChange(themeDetails.copy(description = it)) },
            label = { Text(stringResource(id = R.string.theme_desc_req)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        if (enabled) {
            Text(
                text = stringResource(id = R.string.required_fields),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)),
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}


@Composable
@Preview
fun ModificationScreenPreview() {
    ThemeEntryBody(themeUiState = ThemeUiState(
        ThemeDetails(
            name = "Theme name", description = "Theme Description"
        )
    ), onThemeValueChange = {}, onSaveClick = {})
}