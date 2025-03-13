package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.pages.SocialButton
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.SpanText
import com.santosh.portfolio.utility.ThemeColors
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import com.varabyte.kobweb.silk.components.forms.Button
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea

@Page("/contact")
@Composable
fun ContactPage() {
    val isDarkMode = ThemeColors.isDarkMode.current //
    MainLayout {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .overflow(Overflow.Auto)
                .padding(bottom = 80.px)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .alignItems(AlignItems.Center)
            ) {
                SectionHeader("📞 Contact Us")
                SpanText("Got questions? Fill out the form below and we'll get back to you!")

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .maxWidth(420.px)
                        .margin(leftRight = 16.px, top = 20.px)
                        .padding(24.px)
                        .backgroundColor(Color("#FFFFFF")) // White background for form
                        .borderRadius(12.px) // Softer rounded edges
                        .border(1.px, LineStyle.Solid, Color("#D3D3D3")) // Light grey border
                        // .margin { top(20.px) }
                        .styleModifier {
                            property(
                                "box-shadow",
                                "4px 4px 15px rgba(0, 0, 0, 0.1)"
                            )
                        } // Subtle shadow for depth
                ) {
                    FormInput(label = "Your Name", placeholder = "Enter your name", inputType = InputType.Text)
                    FormInput(label = "Your Email", placeholder = "Enter your email", inputType = InputType.Email)
                    FormInput(label = "Message", placeholder = "Write your message...", isTextArea = true)

                    Button(
                        onClick = { /* Add LinkedIn or Contact link */ },
                        modifier = Modifier
                            .margin(top = 16.px)
                          //  .backgroundColor(if (isDarkMode.value) Color("#4facfe") else Color("#007BFF"))
                            .backgroundColor(if (isDarkMode.value) Color("#007BFF") else Color("#4facfe"))
                            .color(Color.white)
                            .borderRadius(8.px)
                            .padding(10.px, 12.px)
                    ) {
                        Text("📩 Connect with Me")
                    }
                }

                // Social Media Links
                Row(
                    modifier = Modifier
                        .gap(15.px)
                        .margin(top = 20.px, bottom = 40.px)
                ) {
                    SocialButton("LinkedIn", "/icons/linkedin.svg", "https://www.linkedin.com/in/santosh-lokhande-5718476a/")
                    SocialButton("GitHub", "/icons/github1.svg", "https://github.com/lokhandesh/")
                    SocialButton("Email", "/icons/mail.svg", "mailto:your@email.com")
                }
            }
        }
    }
}

// Generic Input Field Component
@Composable
fun FormInput(label: String,placeholder: String,inputType: InputType<String> = InputType.Text, isTextArea: Boolean = false) {
    Column(
        modifier = Modifier.margin(bottom = 16.px) // Spacing between input fields
    ) {
        Span(
            attrs = {
                style {
                    property("font-weight", "bold")
                    property("font-size", "16px")
                    property("margin-bottom", "6px")
                    property("margin-top", "6px")
                }
            }
        ) {
            Text(label)
        }
        if (isTextArea) {
            TextArea(
                attrs = {
                    placeholder(placeholder)
                    style {
                        property("width", "100%")
                        property("padding", "10px")
                        property("border-radius", "6px")
                        property("border", "1px solid #D3D3D3")
                        property("font-size", "14px")
                    }
                }
            )
        } else {
            Input(
                type = inputType,
                attrs = {
                    placeholder(placeholder)
                    style {
                        property("width", "100%")
                        property("padding", "10px")
                        property("border-radius", "6px")
                        property("border", "1px solid #D3D3D3")
                        property("font-size", "14px")
                    }
                }
            )
        }
    }
}