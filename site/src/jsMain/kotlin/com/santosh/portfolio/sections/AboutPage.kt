package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.pages.SocialButton
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.ThemeColors
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flex
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Page("/about")
@Composable
fun AboutPage() {
    val isDarkMode = ThemeColors.isDarkMode.current
    val textColor = if (isDarkMode.value) Color.white else Color.black

    MainLayout {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .alignItems(AlignItems.Center)
                .padding(40.px)
                .maxWidth(900.px)
        ) {
            Column(
                modifier = Modifier.flexGrow(1) // This makes sure the content takes up space
            ) {
                // Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alignItems(AlignItems.Center)
                        .gap(30.px)
                ) {
                    // Profile Image
                    Image(
                        "/icons/santosh.jpeg",
                        alt = "Santosh - Mobile Lead",
                        modifier = Modifier
                            .width(150.px)
                            .height(150.px)
                            .clip(Circle())
                            .styleModifier {
                                property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.2)")
                            }
                    )

                    // Intro Text
                    Column(
                        modifier = Modifier.flex(1)
                    ) {
                        Span(
                            attrs = {
                                style {
                                    property("font-size", "26px")
                                    property("font-weight", "bold")
                                    property("color", textColor.toString())
                                }
                            }
                        ) {
                            Text("👋 Hi, I'm Santosh")
                        }

                        P(
                            attrs = {
                                style {
                                    property("font-size", "18px")
                                    property("line-height", "1.6")
                                    property("font-weight", "bold")
                                    property("color", textColor.toString())
                                }
                            }
                        ) {
                            Text("Senior Mobile Lead Developer with expertise in ")
                            Span() {
                                Text("Android, iOS, and Kotlin Multiplatform (KMP).")
                            }
                            Text(" I specialize in building ")
                            Span() {
                                Text("scalable, high-performance mobile applications")
                            }
                            Text(" while mentoring developers to follow best practices.")
                        }
                    }
                }

                // Section: Mission
                AboutCard(
                    "🎯 Our Mission",
                    "At Dev Prep Hub, we empower mobile developers to succeed in job interviews by providing expert insights, structured interview topics, and resume guidance."
                )

                // Section: Experience
                AboutCard(
                    "👨‍💻 My Experience",
                    "With over a decade of experience, I have developed enterprise-grade mobile applications for banking, finance, and fintech sectors. My expertise includes security, scalable architecture, and performance optimization—ensuring seamless experiences for millions of users."
                )
                // Section: Why Dev Prep Hub
                AboutCard(
                    "📌 Why Dev Prep Hub?",
                    """
                ✅ Real-world interview topics  
                ✅ Insights from industry experts  
                ✅ Deep coverage of Android, iOS, and KMP  
                ✅ Resume tips to make you stand out  
            """.trimIndent()
                )

                // Social Links
                Row(
                    modifier = Modifier
                        .gap(20.px)
                        .margin(top = 20.px, bottom = 80.px)
                        .alignItems(AlignItems.Center)
                        .justifyContent(JustifyContent.Center)
                        .styleModifier {
                            property("display", "flex") // Ensures flex layout
                            property("width", "100%") // Takes full width
                            property("position", "relative") // Keeps position stable
                         //   property("margin-bottom", "env(safe-area-inset-bottom)")
                        }
                ) {
                    SocialButton(
                        "LinkedIn",
                        "/icons/linkedin.svg",
                        "https://www.linkedin.com/in/santosh-lokhande-5718476a/"
                    )
                    SocialButton("GitHub", "/icons/github1.svg", "https://github.com/lokhandesh/")
                    SocialButton("Contact", "/icons/mail.svg", "/contact")
                }
            }
        }
    }

}

@Composable
fun AboutCard(title: String, content: String) {
    val isDarkMode = ThemeColors.isDarkMode.current
    val cardBgColor = if (isDarkMode.value) Color("#222831") else Color("#FFFFFF")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(700.px)
            .margin(top = 20.px)
            .padding(20.px)
            .backgroundColor(cardBgColor)
            .borderRadius(12.px)
            .styleModifier {
                property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.1)")
            }
    ) {
        Column {
            Span(
                attrs = {
                    style {
                        property("font-size", "22px")
                        property("font-weight", "bold")
                        property("color", if (isDarkMode.value) "#00f2fe" else "#007BFF")
                    }
                }
            ) {
                Text(title)
            }

            P(
                attrs = {
                    style {
                        property("font-size", "16px")
                        property("color", if (isDarkMode.value) Color.white else Color.black)
                        property("line-height", "1.6")
                    }
                }
            ) {
                Text(content)
            }
        }
    }

}