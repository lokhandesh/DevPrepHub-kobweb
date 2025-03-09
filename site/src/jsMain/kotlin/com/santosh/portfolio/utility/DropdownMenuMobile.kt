package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.PageContext
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun DropdownMenuMobile(ctx: PageContext, title: String, items: List<Pair<String, String>>, textColor: CSSColorValue) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .position(Position.Relative)
            .cursor(Cursor.Pointer)
            .onClick { isExpanded = !isExpanded }
    ) {
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
                classes("hover-effect")
            }
        ) {
            Text(title)
        }

        if (isExpanded) {
            Column(
                modifier = Modifier
                    .position(Position.Absolute)
                    .backgroundColor(Color("#2A2A2A"))
                    .borderRadius(8.px)
                    .padding(10.px)
                    .margin(top = 5.px)
                    .styleModifier { property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.2)") }
            ) {
                items.forEach { (label, route) ->
                    Span(
                        attrs = {
                            style {
                                property("color", "#FFFFFF")
                                property("padding", "5px 10px")
                                property("cursor", "pointer")
                                property("display", "block")
                                property("transition", "background 0.3s ease")
                            }
                            onClick {
                                ctx.router.navigateTo(route)
                                isExpanded = false // Close dropdown on click
                            }
                            classes("hover-effect")
                        }
                    ) {
                        Text(label)
                    }
                }
            }
        }
    }
}