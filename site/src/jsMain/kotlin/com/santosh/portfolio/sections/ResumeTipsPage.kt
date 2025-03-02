package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.datamodel.Topic
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.SpanText
import com.santosh.portfolio.utility.TopicCardWithNewDesign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px

@Page("/resume-tips")
@Composable
fun ResumeTipsPage() {
    MainLayout {
        Column(
            modifier = Modifier.alignItems(AlignItems.Center)
        ) {
            SectionHeader("📄 Resume Tips for Mobile Developers")
            SpanText("Make your resume stand out with these quick, actionable tips!")

            val topics = listOf(
                Topic(
                    title = "Be Concise",
                    icon = "/icons/concise.svg",
                    points = listOf("1-2 pages max", "Highlight key projects & impact"),
                    background = "linear-gradient(to right, #FF7E5F, #FEB47B)"
                ),
                Topic(
                    title = "Use Keywords",
                    icon = "/icons/keywords.svg",
                    points = listOf("Include Kotlin, Swift, KMP, Jetpack Compose", "Mention relevant frameworks"),
                    background = "linear-gradient(to right, #4facfe, #00f2fe)"
                ),
                Topic(
                    title = "Show Results",
                    icon = "/icons/result.svg",
                    points = listOf("Use metrics (e.g., 'Boosted performance by 30%')", "Highlight real-world impact"),
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

