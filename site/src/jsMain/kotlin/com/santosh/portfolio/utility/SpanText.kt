package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun SpanText(text: String) {
    val isDarkMode = ThemeColors.isDarkMode.current
    val textColor = if (isDarkMode.value) Color.black else Color.white
    Span(
        attrs = {
            style {
                property("font-size", "18px")
                property("font-weight", "500")
                property("text-align", "center")
                property("margin-bottom", "16px")
                property("margin-left", "16px")
                property("margin-right", "16px")
                property("color", textColor.toString())
                property("line-height", "1.6")
            }
        }
    ) {
        Text(text)
    }

}