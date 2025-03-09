package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.datamodel.Topic
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.SpanText
import com.santosh.portfolio.utility.TopicCard
import com.santosh.portfolio.utility.TopicCardWithNewDesign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/kmp-questions")
@Composable
fun KmpQuestionsPage() {

    MainLayout {
        Column(
            modifier = Modifier.alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
                .margin(bottom = 20.px)
        ) {
            SectionHeader("Kotlin Multiplatform (KMP) Interview Topics")
            SpanText("Prepare for cross-platform development with KMP.")


            val topics = listOf(
                Topic(
                    title = "KMP Architecture",
                    icon = "/icons/kmp.svg",
                    points = listOf(
                        "Expect/actual declarations",
                        "Shared & platform-specific code",
                        "Structuring a KMP project",
                        "Gradle setup & dependencies"
                    ),
                    background = "linear-gradient(to right, #FF7E5F, #FEB47B)"
                ),
                Topic(
                    title = "State Management",
                    icon = "/icons/state.svg",
                    points = listOf(
                        "Managing UI state",
                        "ViewModels in KMP",
                        "Using Flows and Coroutines",
                        "Jetpack Compose + SwiftUI integration"
                    ),
                    background = "linear-gradient(to right, #4facfe, #00f2fe)"
                ),
                Topic(
                    title = "Networking & Persistence",
                    icon = "/icons/network.svg",
                    points = listOf(
                        "Ktor for networking",
                        "SQLDelight for local storage",
                        "Multithreading challenges",
                        "Sharing business logic across platforms"
                    ),
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