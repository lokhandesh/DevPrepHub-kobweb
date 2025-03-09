package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
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
            .height(250.px)
            .minHeight(220.px) // Ensure uniform height for all cards
            //.minWidth(250.px)
            .borderRadius(10.px)
            .styleModifier {
                property("transition", "transform 0.3s ease")
                property("cursor", "pointer")
                property("background", background) // Apply gradient background
                property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.3)") // Fix shadow styling
                property("transition", "transform 0.3s ease")
                property("&:hover", "transform: scale(1.05)")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .alignItems(AlignItems.Center)

                .padding(8.px)
        ) {
            Img(src = iconPath, attrs = {
                style {
                    property("width", "45px")
                    property("height", "45px")
                    property("margin-top", "15px")
                }
            })
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.px) // Fixed height for title to maintain alignment
                    .display(DisplayStyle.Flex)
                    .alignItems(AlignItems.Center)
                    .justifyContent(JustifyContent.Center)
            ) {
                P(
                    attrs = {
                        style {
                            property("font-size", "18px")
                            property("font-weight", FontWeight.Bold)
                            property("color", Color.white)
                            property("text-align", "center")
                        }
                    }
                ) {
                    Text(title)
                }
            }
            // List of topics (stays properly aligned)
            // List of topics (Left-aligned with bullets)
            Ul(
                attrs = {
                    style {
                        property("margin-left", "15px") // Add left margin to align bullets
                        property("padding-left", "20px") // Ensure bullets appear correctly
                        property("text-align", "left") // Ensures left alignment
                        property("list-style-type", "disc") // Standard bullet points
                    }
                }
            ) {
                points.forEach {
                    Li(
                        attrs = {
                            style {
                                property("color", "rgba(255, 255, 255, 0.9)")
                                property("margin-bottom", "4px")
                                property("font-size", "16px")
                                property("font-weight", "bold")
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