package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.TopicCard
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/kmp-questions")
@Composable
fun KmpQuestionsPage() {

    MainLayout {
        Column(
            modifier = Modifier.alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
        ) {
            SectionHeader("🌀 Kotlin Multiplatform (KMP) Interview Questions")
            P { Text("Prepare for cross-platform development with KMP.") }

            Row(
                modifier = Modifier
                    .gap(20.px)
                    .margin(top = 30.px)
            ) {
                TopicCard(
                    "KMP Architecture",
                    listOf(
                        "Expect/actual declarations",
                        "Shared & platform-specific code",
                        "Structuring a KMP project",
                        "Gradle setup & dependencies"
                    ),
                    "/icons/kmp.svg"
                )
                TopicCard(
                    "State Management",
                    listOf(
                        "Managing UI state",
                        "ViewModels in KMP",
                        "Using Flows and Coroutines",
                        "Jetpack Compose + SwiftUI integration"
                    ),
                    "/icons/state.svg"
                )
                TopicCard(
                    "Networking & Persistence",
                    listOf(
                        "Ktor for networking",
                        "SQLDelight for local storage",
                        "Multithreading challenges",
                        "Sharing business logic across platforms"
                    ),
                    "/icons/network.svg"
                )
            }
        }
    }

}