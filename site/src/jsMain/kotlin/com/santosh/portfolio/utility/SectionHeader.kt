package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.borderBottom
import com.varabyte.kobweb.compose.css.borderColor
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionHeader(text:String) {
    val isDarkMode = ThemeColors.isDarkMode.current // ✅ Correct way to access compositionLocalOf()
    val textColor = if (isDarkMode.value) Color.white else Color.black
    H1(
        attrs = {
            style {
                fontSize(20.px)
                fontWeight("bold")
                marginBottom(16.px)
                textAlign("center")
                color(textColor)
                padding(12.px, 24.px) // Add padding for spacing
                border(0.5.px, LineStyle.Solid, Color("#D3D3D3")) // Rounded border
                borderRadius(12.px)
                // Prevent text from wrapping and overflow handling
                property("white-space", "nowrap")
                property("overflow", "hidden")
                property("text-overflow", "ellipsis")
            }
        }
    ) {
        Text(text)
    }

}