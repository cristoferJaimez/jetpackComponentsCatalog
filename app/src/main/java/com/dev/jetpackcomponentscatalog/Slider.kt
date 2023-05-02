package com.dev.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BasicSlider() {
    var sliderPositions by remember {
        mutableStateOf(0f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPositions, onValueChange = { sliderPositions = it })
        Text(text = sliderPositions.toString())
    }
}

@Composable
fun AdvancedSlider() {
    var sliderPositions by remember {
        mutableStateOf(0f)
    }


    var sliderValue by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPositions,
            onValueChange = { sliderPositions = it },
            valueRange = 0f..100f,
            steps = 10 - 1,
            onValueChangeFinished = { sliderValue = sliderPositions.toString() }
        )
        Text(text = sliderValue)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RangeSlider() {
    var currentRange by remember {
        mutableStateOf(0f..10f)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.material3.RangeSlider(
            value = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..40f,
            steps = 10 - 1)
        Text(text = currentRange.start.toString() )
        Text(text = currentRange.endInclusive.toString() )
    }

}