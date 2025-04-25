package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.datamodel.Topic
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.SpanText
import com.santosh.portfolio.utility.TopicCardWithNewDesign
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Page("/resume-tips")
@Composable
fun ResumeTipsPage() {
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
            SectionHeader("📄 Resume Tips for Mobile Developers")

            SpanText("Elevate your resume and land interviews faster with these simple tweaks!")

            val topics = listOf(
                Topic(
                    title = "Be Concise",
                    icon = "/icons/concise.svg",
                    points = listOf(
                        "Keep it 1-2 pages max",
                        "Highlight key projects & impact",
                        "Use bullet points instead of paragraphs"
                    ),
                    background = "linear-gradient(to right, #FF7E5F, #FEB47B)"
                ),

                Topic(
                    title = "Use Keywords",
                    icon = "/icons/keywords.svg",
                    points = listOf(
                        "Include Kotlin, Swift, KMP, Jetpack Compose",
                        "Mention relevant frameworks & tools (e.g., Dagger, Hilt, RxJava, Coroutines)"
                    ),
                    background = "linear-gradient(to right, #4facfe, #00f2fe)"
                ),

                Topic(
                    title = "Show Results",
                    icon = "/icons/result.svg",
                    points = listOf(
                        "Use metrics (e.g., 'Boosted performance by 30%')",
                        "Highlight real-world impact (e.g., 'Reduced app crashes by 40%')",
                    ),
                    background = "linear-gradient(to right, #11998e, #38ef7d)"
                ),

                Topic(
                    title = "Highlight Security & Performance",
                    icon = "/icons/resumeperformance.svg",
                    points = listOf(
                        "Mention secure coding practices",
                        "Include app performance optimizations",
                        "Highlight knowledge of encryption & authentication"
                    ),
                    background = "linear-gradient(to right, #f7971e, #ffd200)"
                ),

                Topic(
                    title = "Keep It Well-Formatted",
                    icon = "/icons/resumeformat.svg",
                    points = listOf(
                        "Use a clean, readable font (e.g., Arial, Roboto, Calibri)",
                        "Ensure proper spacing & alignment",
                        "Save as PDF for better compatibility"
                    ),
                    background = "linear-gradient(to right, #5433ff, #20bdff)"
                ),

                Topic(
                    title = "Include a Strong Summary",
                    icon = "/icons/resumesummary.svg",
                    points = listOf(
                        "Highlight years of experience & key expertise",
                        "Showcase leadership or mentoring experience",
                        "Tailor it to the job description"
                    ),
                    background = "linear-gradient(to right, #ff416c, #ff4b2b)"
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
        }
}

