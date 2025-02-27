package com.santosh.portfolio

import androidx.compose.runtime.*
import com.santosh.portfolio.pages.HomePage
import com.santosh.portfolio.sections.AndroidQuestionsPage
import com.santosh.portfolio.sections.ContactPage
import com.santosh.portfolio.sections.KmpQuestionsPage
import com.santosh.portfolio.sections.ResumeTipsPage
import com.santosh.portfolio.sections.iOSQuestionsPage
import com.santosh.portfolio.utility.MainLayout
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}
