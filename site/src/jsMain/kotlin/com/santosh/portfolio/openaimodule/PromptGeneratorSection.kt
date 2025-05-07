package com.santosh.portfolio.openaimodule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Pre
import org.jetbrains.compose.web.dom.TextArea
import io.ktor.client.statement.bodyAsText
import kotlinx.browser.window

val http = HttpClient()

@Composable
fun PromptGeneratorSection() {
    var platform by remember { mutableStateOf("Android") }
    var experience by remember { mutableStateOf("Senior") }
    var topics by remember { mutableStateOf("Dependency Injection, Performance Optimization") }
    var result by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }



    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .maxWidth(600.px)
            .width(100.percent)
            .backgroundColor(Color("#ffffff"))
            .borderRadius(12.px)
            .padding(20.px)
            .margin(top = 32.px)
            .styleModifier {
                property("box-shadow", "0 4px 12px rgba(0,0,0,0.1)")
            }
    ) {
        H4(attrs = { style { property("margin-bottom", "16px") } }) {
            Text("💬 AI-Powered Prompt Generator")
        }

        Input(
            type = InputType.Text,
            attrs = {
                value(platform)
                placeholder("Enter platform (e.g., Android, iOS, KMP)")
                onInput { event -> platform = event.value }
                style {
                    property("width", "100%")
                    property("padding", "10px")
                    property("border-radius", "6px")
                    property("border", "1px solid #D3D3D3")
                    property("font-size", "14px")
                }
            }
        )

        Input(
            type = InputType.Text,
            attrs = {
                value(experience)
                placeholder("Experience level (e.g., Junior, Senior)")
                onInput { event -> experience = event.value }
                style {
                    property("width", "100%")
                    property("padding", "10px")
                    property("border-radius", "6px")
                    property("border", "1px solid #D3D3D3")
                    property("font-size", "14px")
                }
            }
        )

        TextArea(
            attrs = {
                value(topics)
                attr("placeholder", "Enter topics separated by commas")
                onInput { topics = it.value }
                style {
                    property("width", "100%")
                    property("min-height", "80px")
                    property("padding", "10px")
                    property("border-radius", "6px")
                    property("border", "1px solid #ccc")
                    property("resize", "vertical")
                    property("margin-bottom", "12px")
                }
            }
        )

        Button(
            onClick = {
                loading = true
                val prompt = generatePrompt(
                    PromptVault.androidSeniorPrompt.template,
                    mapOf(
                        "platform" to platform,
                        "experience" to experience,
                        "topics" to topics
                    )
                )

                scope.launch {
                    try {
                        println("Clicked Generate Prompt")
                        val encodedPrompt = prompt.encodeURLParameter()
                        val response = http.get("/api/generatePrompt?prompt=$encodedPrompt")
                        result = response.bodyAsText()
                    } catch (e: Exception) {
                        println("Clicked Generate Prompt ${e.message}")
                        result = "⚠️ Error: ${e.message}"
                    } finally {
                        loading = false
                    }
                }
            },
            modifier = Modifier
                .margin(top = 8.px, bottom = 12.px)
                .backgroundColor(Color("#007BFF"))
                .color(Color.white)
                .borderRadius(6.px)
                .padding(10.px, 16.px)
        ) {
            Text("🚀 Generate Prompt")
        }

        if (loading) {
            Span(attrs = {
                style {
                    property("font-size", "16px")
                    property("color", "#007BFF")
                    property("margin-bottom", "12px")
                }
            }) {
                Text("⏳ Generating questions, please wait...")
            }
        }else if (result.isNotBlank()) {
            Pre(
                attrs = {
                    style {
                        property("white-space", "pre-wrap")
                        property("background-color", "#f6f8fa")
                        property("border", "1px solid #ddd")
                        property("border-radius", "8px")
                        property("padding", "16px")
                        property("color", "#333")
                    }
                }
            ) {
                Text(result)
            }
        }

    }


}



fun String.encodeURLParameter(): String =
    window.asDynamic().encodeURIComponent(this) as String



data class PromptTemplate(
    val id: String,
    val category: String,
    val template: String,
    val outputFormat: String
)

object PromptVault {
    val androidSeniorPrompt = PromptTemplate(
        id = "android_senior",
        category = "Interview",
        template = "Generate 3 advanced {{platform}} interview questions for a {{experience}} developer. Focus on {{topics}}.",
        outputFormat = "text"
    )
}

fun generatePrompt(template: String, replacements: Map<String, String>): String {
    var prompt = template
    replacements.forEach { (key, value) ->
        prompt = prompt.replace("{{${key}}}", value)
    }
    return prompt
}