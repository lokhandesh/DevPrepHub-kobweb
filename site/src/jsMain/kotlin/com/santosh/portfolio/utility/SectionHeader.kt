package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionHeader(text:String) {
    val isDarkMode = ThemeColors.isDarkMode.current // ✅ Correct way to access compositionLocalOf()
    val textColor = if (isDarkMode.value) Color.white else Color.black
    H2(
        attrs = {
            style {
                fontSize(24.px)
                fontWeight("bold")
                marginBottom(16.px)
                textAlign("center")
                background("linear-gradient(90deg, #ff7e5f, #feb47b)")
                color(textColor)
                padding(8.px)
                borderRadius(8.px)
            }
        }
    ) {
        Text(text)
    }

}