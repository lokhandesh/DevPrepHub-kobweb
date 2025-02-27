package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.rememberPageContext
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun AnimatedCard(title: String, description: String, route: String) {
    val ctx = rememberPageContext()

    Column(
        modifier = Modifier
            .width(250.px)
            .padding(20.px)
            .borderRadius(15.px)
            .styleModifier {
                property("background", "linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%)")
                property("box-shadow", "0 4px 8px rgba(0, 0, 0, 0.2)")
                property("transition", "transform 0.3s ease, box-shadow 0.3s ease")
                property("&:hover", "transform: scale(1.05); box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3)")
            }
            .onClick { ctx.router.navigateTo(route) }
            .cursor(Cursor.Pointer)
            .textAlign(TextAlign.Center)
    ) {
        // Title with better font and spacing
        P(
            attrs = {
                style {
                    property("font-size", "22px")
                    property("font-weight", "bold")
                    property("color", "#333")
                    property("margin-bottom", "10px")
                }
            }
        ) {
            Text(title)
        }

        // Description with improved font color
        P(
            attrs = {
                style {
                    property("font-size", "16px")
                    property("color", "#555")
                }
            }
        ) {
            Text(description)
        }
    }
}