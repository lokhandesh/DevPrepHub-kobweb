package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.ThemeColors
import com.santosh.portfolio.utility.TopicCard
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Page("/android-questions")
@Composable
fun AndroidQuestionsPage() {
    val isDarkMode = ThemeColors.isDarkMode.current //
    val textColor = if (isDarkMode.value) Color.white else Color.black
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

            Row(
                modifier = Modifier
                    .gap(20.px)
                    .margin(top = 30.px)
            ) {
                TopicCard(
                    "Jetpack Compose",
                    listOf("State management", "Recomposition & performance", "Modifiers & layouts", "Animations"),
                    "/icons/compose.svg"
                )
                TopicCard(
                    "Dependency Injection",
                    listOf("Dagger vs Hilt", "Koin for DI", "Service Locator vs DI", "Scoping & ViewModel integration"),
                    "/icons/di.svg"
                )
                TopicCard(
                    "Performance Optimization",
                    listOf("Memory management", "Profiling tools", "Reducing APK size", "Battery optimizations"),
                    "/icons/performance.svg"
                )
            }
        }
    }
}