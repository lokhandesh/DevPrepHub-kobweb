package com.santosh.portfolio.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun NavBar() {
    val ctx = rememberPageContext()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(rgb(50, 50, 50))
            .padding(16.px)
    ) {
        A(href = "/", attrs = { style { color(Color.white) } }) { Text("Home") }
        Text(" | ")
        A(href = "/android-questions", attrs = { style { color(Color.white) } }) { Text("Android") }
        Text(" | ")
        A(href = "/ios-questions", attrs = { style { color(Color.white) } }) { Text("iOS") }
        Text(" | ")
        A(href = "/kmp-questions", attrs = { style { color(Color.white) } }) { Text("KMP") }
        Text(" | ")
        A(href = "/resume-tips", attrs = { style { color(Color.white) } }) { Text("Resume Tips") }
        Text(" | ")
        A(href = "/contact", attrs = { style { color(Color.white) } }) { Text("Contact") }
    }
}