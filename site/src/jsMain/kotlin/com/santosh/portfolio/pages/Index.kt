package com.santosh.portfolio.pages

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.NavigationButton
import com.santosh.portfolio.utility.SectionHeader
import com.santosh.portfolio.utility.ThemeColors
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.shapes.Circle
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Page("/")
@Composable
fun HomePage() {
    val ctx = rememberPageContext()
    val isDarkMode = ThemeColors.isDarkMode.current //
    val textColor = if (isDarkMode.value) Color.white else Color.black
    MainLayout {
        Column(
            modifier = Modifier.alignItems(AlignItems.Center)
        ) {

            Image(
                "/icons/santosh.jpeg", alt = "My image description",  // Correct path to your image
                modifier = Modifier
                    .width(120.px)  // Set width
                    .height(120.px)  // Set height
                    .clip(Circle())  // Circular image
                    .margin(bottom = 20.px, top = 20.px)  // Add margin below the image
            )
            Span(
                attrs = {
                    style {
                        property("font-size", "24px")
                        property("font-weight", "bold")
                        property("color", textColor.toString())  // Add color if necessary
                    }
                }
            ) {
                Text("Santosh - Mobile Lead")
            }

            SectionHeader("🚀 Job Interview Prep Hub")

            Span(
                attrs = {
                    style {
                        property("font-size", "16px")
                        property("color", textColor.toString())  // Add color if necessary
                    }
                }
            )
             {

                Text("Get ready for Android, iOS, and KMP interviews with expert-curated questions.")
            }

            Row(
                modifier = Modifier
                    .gap(20.px) // Adds spacing between columns
                    .margin(top = 20.px)
            ) {
                NavigationButton(ctx, "Android", "/android-questions")
              //  AnimatedCard("📱 Android", "Master Jetpack, Compose, and DI", "/android-questions")
                NavigationButton(ctx, "iOS", "/ios-questions")
                NavigationButton(ctx, "KMP", "/kmp-questions")
            }
            Row(
                modifier = Modifier
                    .gap(20.px)
                    .margin(top = 40.px) // Adds spacing between sections
            ) {
                NavigationButton(ctx, "Resume Tips", "/resume-tips")
                NavigationButton(ctx, "Contact", "/contact")
            }
        }
    }

}
