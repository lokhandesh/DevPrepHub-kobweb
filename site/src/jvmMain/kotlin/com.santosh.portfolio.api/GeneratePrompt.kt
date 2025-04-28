package com.santosh.portfolio.api


import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.setBodyText
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.*

@Api(routeOverride = "generatePrompt")
suspend fun generatePromptRoute(ctx: ApiContext) {
    val prompt = ctx.req.params["prompt"]

    if (prompt.isNullOrBlank()) {
        ctx.res.status = 400
        ctx.res.setBodyText("Missing prompt parameter")
        return
    }

    val apiKey = System.getenv("OPENAI_API_KEY")

    if (apiKey.isBlank()) {
        ctx.res.status = 500
        ctx.res.setBodyText("Missing OpenAI API key")
        return
    }

    val client = HttpClient() {
        install(ContentNegotiation) {
            json()
        }
    }

    try {
        val response = client.post("https://api.openai.com/v1/chat/completions") {
            headers {
                append(HttpHeaders.Authorization, "Bearer $apiKey")
                append(HttpHeaders.ContentType, "application/json")
            }

            setBody(
                buildJsonObject {
                    put("model", "gpt-3.5-turbo")
                    putJsonArray("messages") {
                        addJsonObject {
                            put("role", "user")
                            put("content", prompt)
                        }
                    }
                }
            )
        }

        val responseText = response.bodyAsText()
        val content = Json.parseToJsonElement(responseText)
            .jsonObject["choices"]?.jsonArray?.getOrNull(0)
            ?.jsonObject?.get("message")?.jsonObject?.get("content")
            ?.jsonPrimitive?.content ?: "⚠️ No content returned."

        ctx.res.setBodyText(content)
    } catch (e: Exception) {
        ctx.res.status = 500
        ctx.res.setBodyText("Error: ${e.localizedMessage}")
    } finally {
        client.close()
    }
}