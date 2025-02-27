package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.margin
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun TopicCard(title: String, topics: List<String>, iconUrl: String) {
    var isExpanded by remember { mutableStateOf(true) }
        Column(
        modifier = Modifier
            .width(320.px)
            .padding(16.px)
            .borderRadius(8.px)
            .backgroundColor(Color("#f4f4f4")) // Light gray background
            .styleModifier { property("box-shadow", "2px 2px 10px #bbbbbb") }
    ) {
        // Header Section with Icon & Expand Button
        Row(
            modifier = Modifier.fillMaxWidth().alignItems(AlignItems.Center).justifyContent(JustifyContent.SpaceBetween)
        ) {
            Row(
                modifier = Modifier.alignItems(AlignItems.Center)
            ) {
                Img(
                    src = iconUrl,
                    attrs = {
                        style {
                            width(24.px)
                            height(24.px)
                            margin(right = 8.px)
                        }
                    }
                )
                H3 { Text(title) }
            }
            Button(attrs = { onClick { isExpanded = !isExpanded } }) {
                Text(if (isExpanded) "▲" else "▼")
            }
        }

        // Collapsible Content
        if (isExpanded) {
            Ul {
                topics.forEach { topic ->
                    Li { Text("🔹 $topic") }
                }
            }
        }
    }
}