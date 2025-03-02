package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun TopicCardWithNewDesign(title: String, points: List<String>, iconPath: String, background: String) {

    Box(
        modifier = Modifier
            .width(300.px)
            .padding(10.px)
            .borderRadius(12.px)
            .styleModifier {
                property("transition", "transform 0.3s ease")
                property("cursor", "pointer")
                property("background", background) // Apply gradient background
                property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.3)") // Fix shadow styling
                property("transition", "transform 0.3s ease")
                property("cursor", "pointer")
                property("&:hover", "transform: scale(1.05)")
            }
    ) {
        Column(
            modifier = Modifier
                .padding(20.px)
                .alignItems(AlignItems.Center)
        ) {
            Img(src = iconPath, attrs = {
                style {
                    property("width", "50px")
                    property("height", "50px")
                    property("margin-bottom", "10px")
                }
            })
            P(
                attrs = {
                    style {
                        property("font-size", "20px")
                        property("font-weight", FontWeight.Bold)
                        property("color", Color.white)
                    }
                }
            ) {
                Text(title)
            }
            Ul {
                points.forEach {
                    Li(
                        attrs = {
                            style {
                                property("color", "rgba(255, 255, 255, 0.9)") // Correct way to apply transparency
                            }
                        }
                    ) {
                        Text(it)
                    }
                }
            }
        }
    }
}