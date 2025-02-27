package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun AnimatedText(text: String, fontSize: CSSNumeric, color: CSSColorValue) {
    val isVisible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible.value = true
    }

    Span(
        attrs = {
            style {
                property("font-size", fontSize.toString())
                property("font-weight", "bold")
                property("color", color.toString())
                property("opacity", if (isVisible.value) "1.0" else "0.0")
                property("transition", "opacity 1s ease-in-out")
            }
        }
    ) {
        Text(text)
    }
}