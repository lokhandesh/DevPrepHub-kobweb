package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.datamodel.Topic
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.ThemeColors
import com.santosh.portfolio.utility.TopicCard
import com.santosh.portfolio.utility.TopicCardWithNewDesign
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

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
                    TopicCardWithNewDesign(topic.title, topic.points, topic.icon, topic.background)
                }
            }
        }
    }
}

