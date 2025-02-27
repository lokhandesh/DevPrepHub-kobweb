package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/resume-tips")
@Composable
fun ResumeTipsPage() {

    MainLayout {
        Column(
            modifier = Modifier.alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
        ) {
            SectionHeader("📄 Resume Tips for Mobile Developers")
            P { Text("Enhance your resume with these proven tips!") }

            Row(
                modifier = Modifier
                    .gap(20.px)
                    .margin(top = 30.px)
            ) {
                ResumeTipCard("📌 Keep it Concise", "Limit to 1-2 pages and highlight key achievements.")
                ResumeTipCard("💡 Use Keywords", "Include tech skills like Kotlin, Swift, KMP, and Jetpack Compose.")
                ResumeTipCard("📈 Show Impact", "Use metrics (e.g., 'Increased app performance by 30%').")
            }
        }
    }

}
@Composable
fun ResumeTipCard(title: String, description: String) {
    Column(
        modifier = Modifier
            .width(300.px)
            .padding(16.px)
            .borderRadius(8.px)
            .backgroundColor(Color.white)
            .styleModifier { property("box-shadow", "2px 2px 10px #bbbbbb") }
    ) {
        H3 { Text(title) }
        P { Text(description) }
    }

}