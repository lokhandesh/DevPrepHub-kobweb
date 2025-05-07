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
    println("⚠️ here prompt $prompt")

    if (prompt.isNullOrBlank()) {
        ctx.res.status = 400
        ctx.res.setBodyText("Missing prompt parameter")
        return
    }

   // val apiKey = System.getenv("OPENAI_API_KEY")
    val apiKey = ""
    val useMockResponse = apiKey.isBlank()

    if (useMockResponse) {
        println("⚠️ OPENAI_API_KEY not set. Using mock response.")
        ctx.res.setBodyText(generateMockResponse(prompt))
        return
    }
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
            ?.jsonPrimitive?.content

        if (content != null) {
            ctx.res.setBodyText(content)
        } else {
            println("⚠️ OpenAI response is empty, using mock.")
           // ctx.res.setBodyText(prompt)
            ctx.res.setBodyText(generateMockResponse(prompt))
        }
    } catch (e: Exception) {
        println("⚠️ Error calling OpenAI: ${e.localizedMessage}. Using mock response.")
        e.printStackTrace()
        ctx.res.status = 200
        ctx.res.setBodyText(generateMockResponse(prompt))
    } finally {
        client.close()
    }
}

/**
 * Returns a static or dynamic mock response based on input prompt.
 */
fun generateMockResponse(prompt: String): String {

    val platform = when {
        prompt.contains("Android", ignoreCase = true) -> "Android"
        prompt.contains("iOS", ignoreCase = true) -> "iOS"
        prompt.contains("KMP", ignoreCase = true) -> "Kotlin Multiplatform"
        else -> "Mobile"
    }
    val questionsByPlatform = mapOf(
        "Android" to listOf(
            listOf(
                "How does Dagger Hilt differ from Dagger 2 in an Android app?",
                "Explain how ViewModel handles configuration changes.",
                "What are the trade-offs between Jetpack Compose and XML-based UI?"
            ),
            listOf(
                "How do you debug memory leaks in an Android application?",
                "Explain the role of WorkManager in background task execution.",
                "How would you architect a large modular Android project?"
            ),
            listOf(
                "Describe how coroutines improve async operations in Android.",
                "How do you handle thread safety in multi-threaded Android apps?",
                "What’s your approach to unit testing ViewModels?"
            ),
            listOf(
                "How do you optimize RecyclerView performance?",
                "Explain how Jetpack Navigation Component works with deep links.",
                "Describe a scenario where LiveData is preferable over Flow."
            ),
            listOf(
                "How do you ensure app security when dealing with sensitive data?",
                "What’s your strategy for implementing offline-first architecture?",
                "Explain how Android handles app process death."
            ),
            listOf(
                "How does Compose handle recomposition efficiently?",
                "Describe best practices for dependency injection in Android.",
                "What tools do you use to analyze ANRs?"
            ),
            listOf(
                "How would you migrate a legacy Android project to Jetpack Compose?",
                "Explain how Room handles data conflicts during inserts.",
                "What is the role of SavedStateHandle?"
            ),
            listOf(
                "How do you implement Clean Architecture in Android?",
                "What are your techniques for reducing app startup time?",
                "How do you manage feature flags in Android?"
            ),
            listOf(
                "How would you secure communication with backend APIs?",
                "How do you handle versioning in Room migrations?",
                "Describe your CI/CD setup for Android."
            ),
            listOf(
                "What is the role of App Startup library?",
                "Explain your approach to managing app-wide state.",
                "How do you perform performance profiling in Android?"
            )
        ),
        "iOS" to listOf(
            listOf(
                "Explain how Combine handles asynchronous data streams.",
                "What are the advantages of using Swift Concurrency over GCD?",
                "Describe your approach to dependency injection in Swift."
            ),
            listOf(
                "How would you manage a large SwiftUI project with modular architecture?",
                "Explain memory management with ARC and retain cycles.",
                "How do you handle state in SwiftUI?"
            ),
            listOf(
                "How do you debug performance bottlenecks in iOS?",
                "What’s your approach to writing testable code in Swift?",
                "How do you implement a custom Combine publisher?"
            ),
            listOf(
                "How do you manage feature flags in a Swift-based iOS app?",
                "Explain the Coordinator pattern and its benefits.",
                "How do you implement offline data caching securely?"
            ),
            listOf(
                "What are your strategies for avoiding massive view controllers?",
                "How do you implement and test background tasks?",
                "How do you monitor memory usage in production?"
            ),
            listOf(
                "What is the difference between @StateObject and @ObservedObject?",
                "How do you optimize rendering performance in SwiftUI?",
                "Describe your crash reporting and monitoring setup."
            ),
            listOf(
                "How do you structure a scalable app architecture in iOS?",
                "How do you handle keychain access and secure storage?",
                "What are common pitfalls when using Combine?"
            ),
            listOf(
                "What are some real-world use cases for async/await in iOS?",
                "How do you ensure smooth animations in SwiftUI?",
                "How would you design a robust logging system?"
            ),
            listOf(
                "How do you implement modular networking in iOS?",
                "What is your approach to managing multiple environments (dev/stage/prod)?",
                "How do you deal with API breaking changes?"
            ),
            listOf(
                "How would you design an iOS app for accessibility?",
                "How do you handle large datasets efficiently in SwiftUI Lists?",
                "What’s your strategy for feature toggles in Swift?"
            )
        ),
        "Kotlin Multiplatform" to listOf(
            listOf(
                "How do you structure a KMP project with clean separation of concerns?",
                "What are the main challenges in managing shared code across iOS and Android?",
                "How do you manage KMP build configurations across platforms?"
            ),
            listOf(
                "How does Kotlin Serialization differ from other libraries in KMP?",
                "Explain how you manage platform-specific logic in shared modules.",
                "How do you implement dependency injection in KMP?"
            ),
            listOf(
                "How do you deal with coroutine dispatchers across platforms?",
                "What testing strategies do you use for KMP shared modules?",
                "Explain the role of expect/actual declarations."
            ),
            listOf(
                "How do you share business logic and models in a KMP app?",
                "How do you optimize build time and dependency management in KMP?",
                "What libraries do you commonly use in KMP?"
            ),
            listOf(
                "How do you structure networking logic in a shared KMP module?",
                "What is the role of Ktor in cross-platform networking?",
                "How do you handle platform-specific storage solutions?"
            ),
            listOf(
                "How do you ensure smooth interoperability between Swift and Kotlin in KMP?",
                "How do you manage logging across platforms?",
                "How do you integrate KMP with existing native apps?"
            ),
            listOf(
                "How do you manage platform-specific errors and exceptions?",
                "What patterns do you follow to abstract platform APIs in shared code?",
                "How do you share analytics tracking logic across platforms?"
            ),
            listOf(
                "What are performance considerations when using KMP in production apps?",
                "How do you modularize a large KMP codebase?",
                "How do you handle Gradle configuration for multiple targets?"
            ),
            listOf(
                "How do you manage iOS framework exports and interoperability issues?",
                "What strategies do you follow for CI/CD in KMP?",
                "What versioning approach do you follow for shared code?"
            ),
            listOf(
                "How do you use SQLDelight or Realm in KMP for cross-platform storage?",
                "How do you sync shared model changes across platforms?",
                "How do you handle compatibility with new Kotlin versions in KMP?"
            )
        )
    )

    val questionSets = questionsByPlatform[platform] ?: listOf()
    val selectedSet = if (questionSets.isNotEmpty()) questionSets.random() else listOf(
        "What’s your development experience across mobile platforms?",
        "How do you approach reusable code architecture?",
        "Describe your mobile CI/CD and testing strategy."
    )

    return buildString {
        appendLine("🔥 Mock Interview Questions for Prompt: \"$platform\"\n")
        selectedSet.forEachIndexed { index, question ->
            appendLine("${index + 1}. $question")
        }
    }.trim()
}