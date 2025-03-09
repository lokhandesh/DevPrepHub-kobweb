package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.PageContext
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun NavLinkMobile(ctx: PageContext, title: String, route: String, textColor: CSSColorValue) {
    Span(
        attrs = {
            style {
                property("color", textColor.toString())
                property("font-size", "18px")
                property("cursor", "pointer")
                property("display", "block") // Ensure full-width clickable area
                property("padding", "12px 16px") // Add spacing inside the button
                property("margin", "5px 0") // Spacing between items
                property("border-radius", "6px") // Rounded corners for a smooth look
                property("transition", "background 0.3s ease, color 0.3s ease")
            }
            onClick { ctx.router.navigateTo(route) }
            classes("hover-effect")
        }
    ) {
        Text(title)
    }
}