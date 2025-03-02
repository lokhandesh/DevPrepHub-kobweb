package com.santosh.portfolio.pages

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.NavigationButton
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.ThemeColors
import com.varabyte.kobweb.compose.css.AlignItems
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
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.selectors.CSSSelector.PseudoClass.hover
import org.jetbrains.compose.web.dom.A
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
                .padding(20.px)
                .maxWidth(600.px)
                .backgroundColor(if (isDarkMode.value) Color("#1E1E1E") else Color("#F5F5F5"))
                .borderRadius(12.px)
                .margin(top = 30.px)
                .styleModifier {
                    property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.2)")
                    property("background", "linear-gradient(to right, #4facfe, #00f2fe)")
                    property("&:hover", "transform: scale(1.03)")
                }
                .padding(24.px)
        ) {
            Column(
                modifier = Modifier.alignItems(AlignItems.Center)
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
                            property("font-size", "24px")
                            property("font-weight", "bold")
                            property("color", textColor.toString())  // Add color if necessary
                        }
                    }
                ) {
                    Text("👋 Hi, I'm Santosh – Mobile Lead")
                }

                P(
                    attrs = {
                        style {
                            property("color", textColor.toString())
                            property("font-size", "16px")
                            property("text-align", "center")
                            property("line-height", "1.6")
                        }
                    }
                ) {
                    Text(
                        "🚀 Passionate **Mobile Lead Developer** with expertise in **Android, iOS, and Kotlin Multiplatform**. " +
                                "I have worked on **highly scalable, secure** mobile applications for global brands, driving best practices in **architecture and performance optimization**."
                    )
                }

                P(
                    attrs = {
                        style {
                            property("color", textColor.toString())
                            property("font-size", "16px")
                            property("text-align", "center")
                            property("line-height", "1.5")
                        }
                    }
                ) {
                    Text(
                        "This **Interview Prep Hub** is created to help mobile developers **excel in job interviews** with expert-curated questions, resume tips, and career guidance!"
                    )
                }

                Row(
                    modifier = Modifier
                        .margin(top = 20.px)
                        .gap(15.px)
                ) {
                    SocialButton("LinkedIn", "/icons/linkedin.svg", "https://www.linkedin.com/in/santosh-lokhande-5718476a/")
                    SocialButton("GitHub", "/icons/github1.svg", "https://github.com/lokhandesh/")
                    SocialButton("Twitter", "/icons/twitter.svg", "https://twitter.com/yourprofile")
                }

                Button(
                    onClick = { /* Add LinkedIn or Contact link */ },
                    modifier = Modifier
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
