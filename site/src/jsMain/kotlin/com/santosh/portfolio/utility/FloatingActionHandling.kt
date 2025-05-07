package com.santosh.portfolio.utility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.santosh.portfolio.openaimodule.PromptGeneratorSection
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.forms.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun FloatingActionHandling() {
    var showPromptPopup by remember { mutableStateOf(false) }
    Div(attrs = {
        style {
            property("position", "fixed")
            property("bottom", "24px")
            property("right", "24px")
            property("width", "60px")
            property("height", "60px")
            property("border-radius", "50%")
            property("background-color", "#007BFF")
            property("display", "flex")
            property("justify-content", "center")
            property("align-items", "center")
            property("box-shadow", "0 4px 12px rgba(0, 0, 0, 0.3)")
            property("cursor", "pointer")
            property("z-index", "999")
        }
        onClick { showPromptPopup = true }
    }) {
        Img(
            src = "/icons/questionsbot.png", // Replace with your chatbot icon path
            attrs = {
                style {
                    property("width", "28px")
                    property("height", "28px")
                }
            }
        )
    }

    if (showPromptPopup) {
        Div(attrs = {
            style {
                property("position", "fixed")
                property("top", "0")
                property("left", "0")
                property("width", "100vw")
                property("height", "100vh")
                property("background", "rgba(0, 0, 0, 0.5)")
                property("display", "flex")
                property("justify-content", "center")
                property("align-items", "center")
                property("z-index", "1000")
            }
            onClick { showPromptPopup = false }
        }) {
            Div(attrs = {
                style {
                    property("background", "white")
                    property("padding", "24px")
                    property("border-radius", "12px")
                    property("box-shadow", "0 4px 12px rgba(0, 0, 0, 0.2)")
                    property("width", "90%")
                    property("max-width", "600px")
                }
                onClick { it.stopPropagation() }
            }) {
                // Close button
                Div(attrs = {
                    style {
                        property("text-align", "right")
                        property("margin-bottom", "8px")
                    }
                }) {
                    Button(
                        onClick = { showPromptPopup = false},
                        modifier = Modifier
                            .styleModifier {
                                property("background", "none")
                                property("border", "none")
                                property("font-size", "20px")
                                property("cursor", "pointer")
                                property("color", "#999")
                            }
                    ) {
                        Text("❌")
                    }

                }

                PromptGeneratorSection()
            }
        }
    }



}