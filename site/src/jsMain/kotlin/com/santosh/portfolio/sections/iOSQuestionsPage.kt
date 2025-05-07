package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.santosh.portfolio.datamodel.Topic
import com.santosh.portfolio.openaimodule.PromptGeneratorSection
import com.santosh.portfolio.utility.FloatingActionHandling
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.SpanText
import com.santosh.portfolio.utility.TopicCard
import com.santosh.portfolio.utility.TopicCardWithNewDesign
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Button
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/ios-questions")
@Composable
fun iOSQuestionsPage() {
    var showPromptPopup by remember { mutableStateOf(false) }
    MainLayout {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .overflow(Overflow.Auto)
                .padding(bottom = 80.px)
        ) {
            Column(
                modifier = Modifier
                    .alignItems(AlignItems.Center)
                    .fillMaxWidth()
            ) {
                SectionHeader("🍏 iOS Interview Topics")
                SpanText("Prepare for Swift, UIKit, SwiftUI, and Memory Management.")


                val topics = listOf(
                    Topic(
                        title = "Swift Basics",
                        icon = "/icons/swift.svg",
                        points = listOf(
                            "Optionals & type safety",
                            "Structs vs Classes",
                            "Protocols & extensions",
                            "Concurrency with async/await"
                        ),
                        background = "linear-gradient(to right, #FF7E5F, #FEB47B)" // Background gradient
                    ),
                    Topic(
                        title = "UIKit vs SwiftUI",
                        icon = "/icons/uikit.svg",
                        points = listOf(
                            "Differences & when to use",
                            "Navigation & State Management",
                            "Custom UI components",
                            "Animations & transitions"
                        ),
                        background = "linear-gradient(to right, #4facfe, #00f2fe)"
                    ),
                    Topic(
                        title = "Memory Management",
                        icon = "/icons/memory.svg",
                        points = listOf(
                            "Automatic Reference Counting (ARC)",
                            "Strong, weak, and unowned references",
                            "Retain cycles & memory leaks"
                        ),
                        background = "linear-gradient(to right, #11998e, #38ef7d)"
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .maxWidth(1200.px)
                        .gap(20.px)
                        .margin(top = 0.px, bottom = 60.px)
                        .flexWrap(FlexWrap.Wrap)
                        .justifyContent(JustifyContent.Center)
                        .padding(leftRight = 20.px)
                ) {
                    topics.forEach { topic ->
                        TopicCardWithNewDesign(topic.title, topic.points, topic.icon, topic.background)
                    }
                }
            }
        }
        FloatingActionHandling()
    }
}