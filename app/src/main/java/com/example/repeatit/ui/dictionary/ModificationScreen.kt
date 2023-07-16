package com.example.repeatit.ui.dictionary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.repeatit.ui.trainings.TrainScreen


@Composable
fun ModificationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Modification")
    }
}


@Composable
@Preview
fun TrainingScreenPreview() {
    ModificationScreen()
}