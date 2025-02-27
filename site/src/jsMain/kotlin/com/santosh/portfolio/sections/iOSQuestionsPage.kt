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

@Page("/ios-questions")
@Composable
fun iOSQuestionsPage() {
    MainLayout {
        Column(
            modifier = Modifier.alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
        ) {
            SectionHeader("🍏 iOS Interview Questions")
            P { Text("Prepare for Swift, UIKit, SwiftUI, and Memory Management.") }

            Row(
                modifier = Modifier
                    .gap(20.px)
                    .margin(top = 30.px)
            ) {
                TopicCard(
                    "Swift Basics",
                    listOf(
                        "Optionals & type safety",
                        "Structs vs Classes",
                        "Protocols & extensions",
                        "Concurrency with async/await"
                    ),
                    "/icons/swift.svg"
                )
                TopicCard(
                    "UIKit vs SwiftUI",
                    listOf(
                        "Differences & when to use",
                        "Navigation & State Management",
                        "Custom UI components",
                        "Animations & transitions"
                    ),
                    "/icons/uikit.svg"
                )
                TopicCard(
                    "Memory Management",
                    listOf(
                        "Automatic Reference Counting (ARC)",
                        "Strong, weak, and unowned references",
                        "Retain cycles & memory leaks",
                        "Profiling with Instruments"
                    ),
                    "/icons/memory.svg"
                )
            }
        }
    }
}