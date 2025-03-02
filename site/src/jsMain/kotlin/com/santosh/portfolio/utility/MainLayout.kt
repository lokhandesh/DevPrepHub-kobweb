package com.santosh.portfolio.utility

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px


@Composable
fun MainLayout(content: @Composable () -> Unit) {

    val isDarkMode = ThemeColors.isDarkMode.current //
    val backgroundColor = if (isDarkMode.value) Color("#121212") else Color("#F8F9FA")
    val backgroundGradient = if (isDarkMode.value)
        "linear-gradient(to right, #0F2027, #203A43, #2C5364)"
    else
        "linear-gradient(to right, #F8F9FA, #00f2fe)"
    CompositionLocalProvider(ThemeColors.isDarkMode provides isDarkMode) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .backgroundColor(backgroundColor) // Fallback color
                .padding(top = 50.px)
                .alignItems(AlignItems.Center)
                .styleModifier {
                    property("background", backgroundGradient)
                }
        ) {
            MainHeader(
                isDarkMode = isDarkMode.value,
                onThemeToggle = { isDarkMode.value = !isDarkMode.value }
            )
            content() // Render the page content passed as a parameter
        }
    }
}