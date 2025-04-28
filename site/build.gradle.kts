import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "com.santosh.portfolio"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
        }
    }
}

kotlin {
   // configAsKobwebApplication("portfolio")

    js(IR) {
        browser()
        binaries.executable()
    }

    jvm()

    sourceSets {
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation("io.ktor:ktor-client-js:2.3.7")

        }
        jvmMain.dependencies {
            implementation("io.ktor:ktor-server-core:2.3.7")
            implementation("io.ktor:ktor-server-netty:2.3.7")
            implementation("io.ktor:ktor-server-cio:2.3.7") // optional for local testing
            implementation("io.ktor:ktor-server-content-negotiation:2.3.7")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")

            api("io.ktor:ktor-client-core:2.3.7")
            api("io.ktor:ktor-client-cio:2.3.7")
            api("io.ktor:ktor-client-cio-jvm:2.3.7")
            api("io.ktor:ktor-client-content-negotiation:2.3.7")
            api("io.ktor:ktor-client-serialization:2.3.7")

            implementation("com.varabyte.kobweb:kobweb-api:0.20.3")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
        }
    }
}
