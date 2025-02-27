package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.transition
import com.varabyte.kobweb.core.PageContext
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun NavigationButton(ctx: PageContext, label: String, route: String) {
    Button(
        attrs = {
            style {
                backgroundColor(rgb(255, 99, 71)) // Tomato color
                color(Color.white)
                fontSize(18.px)
                padding(12.px, 24.px)
                borderRadius(8.px)
                border { "none" }
                cursor("pointer")
                property("transition", "background-color 0.3s ease")
            }
            onClick { ctx.router.navigateTo(route) }
            onMouseOver { it.target?.asDynamic()?.style?.backgroundColor = "#ff6347" } // Darker on hover
            onMouseOut { it.target?.asDynamic()?.style?.backgroundColor = "#ff5733" }
        }
    ) {
        Text(label)
    }
}