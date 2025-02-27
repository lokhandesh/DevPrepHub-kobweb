package com.santosh.portfolio.utility

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

object ThemeColors {
    val isDarkMode = compositionLocalOf { mutableStateOf(true) }
    val textColor: ProvidableCompositionLocal<CSSColorValue> = compositionLocalOf {
        Color.white // Default value
    }

}