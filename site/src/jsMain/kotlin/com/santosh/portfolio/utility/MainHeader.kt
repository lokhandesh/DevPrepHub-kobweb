package com.santosh.portfolio.utility

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.rememberPageContext
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainHeader(isDarkMode: Boolean, onThemeToggle: () -> Unit) {

    //var isDarkMode by remember { mutableStateOf(true) }
    val backgroundColor = if (isDarkMode) Color("#1E1E1E") else Color("#F0F0F0")
    val textColor = if (isDarkMode) Color.white else Color.black
    val buttonBgColor = if (isDarkMode) Color("#444444") else Color("#FFFFFF")

    val ctx = rememberPageContext()
    var isMenuOpen by remember { mutableStateOf(false) } // Toggle for mobile menu
    val isMobile = remember { mutableStateOf(window.innerWidth <= 768) }

    LaunchedEffect(Unit) {
        window.addEventListener("resize", {
            isMobile.value = (window.innerWidth <= 768)
            if (!isMobile.value) isMenuOpen = false
        })
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.px)
            .backgroundColor(backgroundColor)  // Dark background
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.SpaceBetween)
            .styleModifier {
                property("padding", "10px 20px")
            }
    ) {
        // Site Logo or Title
        Span(
            attrs = {
                style {
                    property("font-size", "24px")
                    property("font-weight", "bold")
                    property("color", textColor.toString())
                    property("cursor", "pointer")
                }
                onClick { ctx.router.navigateTo("/") }  // Handle click event
            }
        ) {
            Text("🚀 Dev Prep Hub")  // The actual text content
        }

        // Desktop Navigation (Hidden on Mobile)
        if (!isMobile.value) {
            Row(
                modifier = Modifier.gap(20.px)
            ) {
                NavLink(ctx, "Home", "/", textColor)
                NavLink(ctx, "About", "/about", textColor)
                DropdownMenu(
                    ctx, "Interview Topics", listOf(
                        "Android" to "/android-questions",
                        "iOS" to "/ios-questions",
                        "KMP" to "/kmp-questions"
                    ), textColor
                )
                NavLink(ctx, "Resume Tips", "/resume-tips", textColor)
                NavLink(ctx, "Contact", "/contact", textColor)
            }
        }
        // 🌙 Theme Toggle Button (ALWAYS VISIBLE)
        if (!isMobile.value) {
            Button(
                attrs = {
                    style {
                        property("background-color", buttonBgColor.toString())
                        property("color", textColor.toString())
                        property("padding", "8px 16px")
                        property("border", "none")
                        property("border-radius", "5px")
                        property("cursor", "pointer")
                        property("margin-left", "20px") // Add spacing from nav
                    }
                    onClick { onThemeToggle() }
                }
            ) {
                Text(if (isDarkMode) "☀️ Light Mode" else "🌙 Dark Mode")
            }
        }


    }

}

// Individual Navigation Link
@Composable
fun NavLink(ctx: PageContext, title: String, route: String, textColor: CSSColorValue) {
    Span(
        attrs = {
            style {
                property("color", textColor.toString())
                property("font-size", "18px")
                property("cursor", "pointer")
                property("transition", "color 0.3s ease")
            }
            onClick { ctx.router.navigateTo(route) }
            classes("hover-effect")
        }
    ) {
        Text(title)
    }
}

// Dropdown Menu for Interview Questions
@Composable
fun DropdownMenu(ctx: PageContext, title: String, items: List<Pair<String, String>>, textColor: CSSColorValue) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .position(Position.Relative) // Ensure the dropdown appears relative to the parent
            .cursor(Cursor.Pointer)
            .onClick { isExpanded = !isExpanded }
    ) {
        // Title of the dropdown
        Span(
            attrs = {
                style {
                    property("color", textColor.toString())
                    property("font-size", "18px")
                    property("cursor", "pointer")
                    property("transition", "color 0.3s ease")
                    // Apply styles for hover effect if required
                }
                classes("hover-effect")
            }
        ) {
            Text(title)
        }

        // Dropdown menu (only visible when isExpanded is true)
        if (isExpanded) {
            Column(
                modifier = Modifier
                    .position(Position.Absolute)
                    .backgroundColor(Color("#2A2A2A"))
                    .borderRadius(8.px)
                    .padding(10.px)
                    .margin(top = 25.px)
                    .styleModifier { property("box-shadow", "0px 4px 10px rgba(0, 0, 0, 0.2)") }
            ) {
                items.forEach { (label, route) ->
                    // Individual dropdown item
                    Span(
                        attrs = {
                            style {
                                property("color", "#FFFFFF")
                                property("padding", "10px 20px")
                                property("cursor", "pointer")
                                property("transition", "background 0.3s ease")
                                property("border-radius", "5px")
                                property("margin-bottom", "5px") // Space between items
                                // Hover effect styling
                                property("background-color", if (isExpanded) "#444444" else "transparent")
                            }
                            onClick {
                                ctx.router.navigateTo(route)
                                isExpanded = false // Close dropdown on click
                            }
                            classes("hover-effect")
                        }
                    ) {
                        Text(label) // Display each item
                    }
                }
            }
        }
    }
}

