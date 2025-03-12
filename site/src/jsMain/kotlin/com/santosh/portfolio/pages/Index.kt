package com.santosh.portfolio.pages

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.ThemeColors
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.selectors.CSSSelector.PseudoClass.hover
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Page("/")
@Composable
fun HomePage() {
    val ctx = rememberPageContext()
    val isDarkMode = ThemeColors.isDarkMode.current //
    val textColor = if (isDarkMode.value) Color.white else Color.black
    MainLayout {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .justifyContent(JustifyContent.Center)
                .alignItems(AlignItems.Center)
                .styleModifier {
                    property("min-height", "100vh") // Ensures full height
                    property("overflow-y", "auto") // Enables scrolling when needed
                    property("padding-top", "80px") // Ensures space on top
                    property("padding-bottom", "60px")
                }
        ) {
            Column(
                modifier = Modifier
                    .maxWidth(600.px)
                    .width(90.percent)
                    .backgroundColor(if (isDarkMode.value) Color("#1E1E1E") else Color("#F5F5F5"))
                    .borderRadius(16.px)
                    .padding(24.px)
                    .margin(top = 40.px, bottom = 40.px)
                    .styleModifier {
                        property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.2)")
                        property("background", "linear-gradient(to right, #4facfe, #00f2fe)")
                        property("transition", "transform 0.3s ease-in-out")
                    }
            ) {
                Column(
                    modifier = Modifier.alignItems(AlignItems.Center)
                        .maxWidth(600.px) // Makes content fit mobile screens
                        .width(90.percent)
                        .alignItems(AlignItems.Center)
                        .styleModifier {
                            property("overflow", "auto") // Ensures scrolling inside if needed
                        }
                ) {

                    Image(
                        "/icons/santosh.jpeg", alt = "My image description",  // Correct path to your image
                        modifier = Modifier
                            .width(120.px)  // Set width
                            .height(120.px)  // Set height
                            .clip(Circle())  // Circular image
                            .margin(bottom = 20.px, top = 20.px)  // Add margin below the image
                    )
                    Span(
                        attrs = {
                            style {
                                property("font-size", "26px")
                                property("font-weight", "bold")
                                property("color", textColor.toString())  // Add color if necessary
                            }
                        }
                    ) {
                        Text("Hey, I'm Santosh")
                    }

                    P(
                        attrs = {
                            style {
                                property("font-size", "18px")
                                property("font-weight", "bold")
                                property("color", textColor.toString())
                                property("text-align", "center")
                                property("line-height", "1.6")
                            }
                        }
                    ) {
                        Span { Text("🔹 ") }
                        Span(attrs = {
                            style {
                                property("font-weight", "bold")
                                property("color", textColor.toString())
                            }
                        }) {
                            Text("Mobile Lead ")
                        }
                        Text(" specializing in ")
                        Span(attrs = {
                            style {
                                property("font-weight", "bold")
                                property("color", textColor.toString())
                            }
                        }) {
                            Text("Android, iOS, and Kotlin Multiplatform.")
                        }
                        Br()
                        Text("Passionate about building ")
                        Span(attrs = {
                            style {
                                property("font-weight", "bold")
                                property("color", textColor.toString())
                            }
                        }) {
                            Text("secure, high-performance apps")
                        }
                        Text(" for global brands.")
                    }

                    P(
                        attrs = {
                            style {
                                property("font-size", "18px")
                                //  property("font-weight", "bold")
                                property("color", textColor.toString())
                                property("text-align", "center")
                                property("line-height", "1.6")
                                property("max-width", 550.px)
                                property("margin-top", "10px")
                            }
                        }
                    ) {
                        Span { Text("💡 ") }
                        Text("Welcome to the ")
                        Span() {
                            Text("Interview Prep Hub")
                        }
                        Text(" — your go-to resource for mastering mobile developer job interviews.")
                        Br()
                        Text("Explore ")
                        Span() {
                            Text("essential interview topics, resume tips, and career guidance")
                        }
                        Text(" tailored to help you confidently navigate technical discussions and showcase your expertise.")
                    }

                    Row(
                        modifier = Modifier
                            .margin(top = 20.px)
                            .gap(15.px)
                            .maxWidth(600.px)
                            .width(90.percent)
                            .flexWrap(FlexWrap.Wrap)
                            .justifyContent(JustifyContent.Center)
                    ) {
                        SocialButton(
                            "LinkedIn",
                            "/icons/linkedin.svg",
                            "https://www.linkedin.com/in/santosh-lokhande-5718476a/"
                        )
                        SocialButton("GitHub", "/icons/github1.svg", "https://github.com/lokhandesh/")
                        SocialButton("Twitter", "/icons/twitter.svg", "https://twitter.com/yourprofile")
                    }

                    Button(
                        onClick = { /* Add LinkedIn or Contact link */ },
                        modifier = Modifier
                            .maxWidth(300.px) // Keeps buttons from stretching too wide on desktop
                            .width(90.percent)
                            .margin(top = 16.px)
                            .backgroundColor(if (isDarkMode.value) Color("#4facfe") else Color("#007BFF"))
                            .color(Color.white)
                            .borderRadius(8.px)
                            .padding(10.px, 12.px)
                    ) {
                        Text("📩 Connect with Me")
                    }

                }
            }
        }
    }

}

// Social Media Button
@Composable
fun SocialButton(name: String, iconPath: String, url: String) {
    A(href = url, attrs = {
        style {
            property("display", "flex")
            property("align-items", "center")
            property("gap", "8px")
            property("text-decoration", "none")
            property("padding", "8px 12px")
            property("border-radius", "8px")
            property("background", "white")
            property("color", "black")
            property("box-shadow", "0px 2px 5px rgba(0, 0, 0, 0.2)")
            property("transition", "transform 0.2s")
            property("&:hover", "transform: scale(1.1)")
        }
    }) {
        Img(src = iconPath, alt = "$name Icon", attrs = { style { property("width", "20px") } })
        Text(name)
    }
}
