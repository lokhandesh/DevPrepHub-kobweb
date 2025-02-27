package com.santosh.portfolio.sections

import androidx.compose.runtime.Composable
import com.santosh.portfolio.utility.MainLayout
import com.santosh.portfolio.utility.SectionHeader
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Page("/contact")
@Composable
fun ContactPage() {
    MainLayout {
        Column(
            modifier = Modifier.alignItems(com.varabyte.kobweb.compose.css.AlignItems.Center)
        ) {
            SectionHeader("📞 Contact Us")
            P { Text("Got questions? Reach out!") }

            Column(
                modifier = Modifier
                    .width(400.px)
                    .padding(20.px)
                    .backgroundColor(Color.white)
                    .borderRadius(8.px)
                    .styleModifier { property("box-shadow", "2px 2px 10px #bbbbbb") }
            ) {
                Text("Your Name:")
                Input(type = InputType.Text, attrs = { placeholder("Enter your name") })

                Text("Your Email:")
                Input(type = InputType.Email, attrs = { placeholder("Enter your email") })

                Text("Message:")
                TextArea(attrs = { placeholder("Write your message...") })

                Button(attrs = { onClick { /* Handle submission */ } }) {
                    Text("Submit")
                }
            }
        }
    }
}