package com.santosh.portfolio.utility

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.rememberPageContext
import kotlinx.browser.window
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text


@Composable
fun MainLayout(content: @Composable () -> Unit) {

    val isDarkMode = ThemeColors.isDarkMode.current //
    val backgroundColor = if (isDarkMode.value) Color("#121212") else Color("#F8F9FA")
    val backgroundGradient = if (isDarkMode.value)
        "linear-gradient(to right, #0F2027, #203A43, #2C5364)"
    else
        "linear-gradient(to right, #F8F9FA, #00f2fe)"

    var isMenuOpen by remember { mutableStateOf(false) } // Toggle for mobile menu
    val isMobile = remember { mutableStateOf(window.innerWidth <= 768) }
    val ctx = rememberPageContext()
    val textColor = if (isDarkMode.value) Color.white else Color.black

    CompositionLocalProvider(ThemeColors.isDarkMode provides isDarkMode) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .backgroundColor(backgroundColor) // Fallback color
                .padding(top = 50.px)
                .alignItems(AlignItems.Center)
                .styleModifier {
                    property("background", backgroundGradient)
                   // property("overflow", "hidden") // Prevent scrolling of MainLayout
                   // property("height", "100vh") // Ensure it takes full viewport height
                }
        ) {

            if (isMobile.value) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .position(Position.Absolute)
                        .top(10.px)
                        .right(20.px)
                        .justifyContent(JustifyContent.FlexEnd)
                        .alignItems(AlignItems.Center)
                        .gap(4.px)
                        .zIndex(1000) // Ensure it's above other elements
                ) {
                    // 🌙 Theme Toggle Icon
                    Button(
                        attrs = {
                            style {
                                property("background", "none")
                                property("border", "none")
                                property("cursor", "pointer")
                                property("font-size", "18px")
                                property("color", if (isDarkMode.value) "white" else "black")
                                property("padding", "5px") // Reduce padding
                                property("min-width", "0px") // Ensures no extra spacing
                            }
                            onClick { isDarkMode.value = !isDarkMode.value }
                        }
                    ) {
                        Text(if (isDarkMode.value) "☀️" else "🌙")
                    }

                    // 🍔 Hamburger Menu Icon
                    Button(
                        attrs = {
                            style {
                                property("background", "none")
                                property("border", "none")
                                property("cursor", "pointer")
                                property("font-size", "24px")
                                property("color", if (isDarkMode.value) "white" else "black")
                                property("padding", "5px") // Reduce padding
                                property("min-width", "0px") // Ensures no extra spacing
                            }
                            onClick { isMenuOpen = !isMenuOpen }
                        }
                    ) {
                        Text(if (isMenuOpen) "✖️" else "☰") // Toggle between ☰ and ✖️
                    }
                }
            }

            if (isMenuOpen) {
                Div(
                    attrs = {
                        style {
                            property("position", "fixed")
                            property("top", "0")
                            property("left", "0")
                            property("width", "100vw")
                            property("height", "100vh")
                            property("background", "rgba(0, 0, 0, 0.5)") // Semi-transparent black
                            property("z-index", "999") // Below the drawer but above content
                        }
                        onClick { isMenuOpen = false } // Close when clicking outside
                    }
                )
            }

            Column(
                modifier = Modifier
                    .position(Position.Fixed)
                    .backgroundColor(Color("#222831")) // Dark stylish background
                    .width(250.px) // Fixed width for drawer
                    .height(100.vh) // Full height
                    .right(if (isMenuOpen) 0.px else (-260).px) // Animate in from the left
                    .styleModifier {
                        property("right", if (isMenuOpen) "0px" else "-260px") // Slide effect
                        property("transition", "right 0.3s ease-in-out") // Smooth animation
                    }
                    .padding(20.px)
                    .zIndex(1000) // Keep it on top
            ) {


                // App Logo / Title
                Span(
                    attrs = {
                        style {
                            property("font-size", "22px")
                            property("font-weight", "bold")
                            property("color", "white")
                            property("margin-bottom", "20px")
                        }
                    }
                ) {
                    Text("🚀 Dev Prep Hub")
                }

                // Navigation Links (Styled like a native mobile menu)
                NavLinkMobile(ctx, "Home", "/", Color.white)
                NavLinkMobile(ctx, "About", "/about", Color.white)
                DropdownMenuMobile(ctx, "Interview Topics", listOf(
                    "Android" to "/android-questions",
                    "iOS" to "/ios-questions",
                    "KMP" to "/kmp-questions"
                ), Color.white)
                NavLinkMobile(ctx, "Resume Tips", "/resume-tips", Color.white)
                NavLinkMobile(ctx, "Contact", "/contact", Color.white)
            }



            MainHeader(
                isDarkMode = isDarkMode.value,
                onThemeToggle = { isDarkMode.value = !isDarkMode.value }
            )
            /*Box(
                modifier = Modifier
                    .fillMaxSize()
                    .styleModifier {
                        property("overflow", "auto") // Allow only this content to scroll
                        property("max-height", "calc(100vh - 50px)") // Subtract header height
                    }
            ) {*/
                content() // Render the page content passed as a parameter
         //   }
        }
    }
}


