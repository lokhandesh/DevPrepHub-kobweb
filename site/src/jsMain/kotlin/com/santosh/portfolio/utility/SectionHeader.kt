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
                fontSize(16.px)
                fontWeight("bold")
                textAlign("center")
                color(textColor)
                padding(16.px, 16.px)
                border(0.5.px, LineStyle.Solid, Color("#D3D3D3"))
                borderRadius(12.px)
                property("white-space", "normal")
                property("overflow", "visible")
                property("text-overflow", "unset")
            }
        }
    ) {
        Text(text)
    }

}