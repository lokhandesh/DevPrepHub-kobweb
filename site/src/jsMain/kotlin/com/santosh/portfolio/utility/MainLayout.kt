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
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

@Composable
fun MainLayout(content: @Composable () -> Unit) {

    val isDarkMode = ThemeColors.isDarkMode.current // ✅ Correct way to access compositionLocalOf()
    val textColor = if (isDarkMode.value) Color.white else Color.black
    val backgroundColor = if (isDarkMode.value) Color("#121212") else Color("#4facfe")
    CompositionLocalProvider(ThemeColors.isDarkMode provides isDarkMode,
        ThemeColors.textColor provides textColor) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .backgroundColor(backgroundColor) // Fallback color
                .padding(top = 50.px)
                .alignItems(AlignItems.Center)
        ) {
            MainHeader(
                isDarkMode = isDarkMode.value,
                onThemeToggle = { isDarkMode.value = !isDarkMode.value }
            )
            content() // Render the page content passed as a parameter
        }
    }
}