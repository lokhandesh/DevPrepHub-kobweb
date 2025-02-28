package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.ThemeColors
import com.santosh.portfolio.utility.TopicCard
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Style
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Page("/android-questions")
@Composable
fun AndroidQuestionsPage() {
    val isDarkMode = ThemeColors.isDarkMode.current //
    val textColor = if (isDarkMode.value) Color.white else Color.black
    val cardBackground = if (isDarkMode.value) "linear-gradient(to right, #232526, #414345)" else "linear-gradient(to right, #4facfe, #00f2fe)"
    MainLayout {
        Column(
            modifier = Modifier.alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
        ) {
            SectionHeader("🤖 Android Interview Questions")
            P {
                Span(
                    attrs = {
                        style {
                            property("color", textColor.toString()) // Use dynamic theme color
                            property("font-size", "16px")
                        }
                    }
                ) {
                    Text("Master Jetpack, Compose, DI, and more!")
                }
            }


            val topics = listOf(
                Topic(
                    title = "Jetpack Compose",
                    icon = "/icons/compose.svg",
                    points = listOf("State management", "Recomposition & performance", "Modifiers & layouts", "Animations"),
                    background = "linear-gradient(to right, #FF7E5F, #FEB47B)" // Background gradient
                ),
                Topic(
                    title = "Dependency Injection",
                    icon = "/icons/di.svg",
                    points = listOf("Dagger vs Hilt", "Koin for DI", "Service Locator vs DI", "Scoping & ViewModel integration"),
                    background = "linear-gradient(to right, #4facfe, #00f2fe)"
                ),
                Topic(
                    title = "Performance Optimization",
                    icon = "/icons/performance.svg",
                    points = listOf("Memory management", "Profiling tools", "Reducing APK size", "Battery optimizations"),
                    background = "linear-gradient(to right, #11998e, #38ef7d)"
                )
            )

            Row(
                modifier = Modifier
                    .gap(20.px)
                    .margin(top = 30.px)
                    .flexWrap(FlexWrap.Wrap) // Responsive wrap for smaller screens
                    .justifyContent(JustifyContent.Center)
            ) {
                topics.forEach { topic ->
                    TopicCardNew(topic.title, topic.points, topic.icon, topic.background)
                }
            }
        }
    }
}

data class Topic(
    val title: String,
    val icon: String,
    val points: List<String>,
    val background: String
)

@Composable
fun TopicCardNew(title: String, points: List<String>, iconPath: String, background: String) {

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