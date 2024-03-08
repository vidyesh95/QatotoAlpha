package com.astral.qatotoalpha.feature.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class HomeScreenViewModel(
    //private val homeScreenUseCase: HomeScreenUseCase
    val tintCo: String
) : ViewModel() {

    var tintColor by mutableStateOf(Color(0xFF00FF00))
        private set

    /*fun onTintColorChanged(color: Color) {
        tintColor = color
    }*/
    fun onTintColorChanged() {
        tintColor = Color(0xFF0000FF)
    }
}