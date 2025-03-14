package com.santosh.portfolio.utility

import kotlinx.browser.document
import org.w3c.dom.HTMLElement

fun updateThemeColor(color: String) {
    val metaThemeColor = document.querySelector("meta[name=theme-color]") as? HTMLElement
    if (metaThemeColor == null) {
        val newMeta = document.createElement("meta") as HTMLElement
        newMeta.setAttribute("name", "theme-color")
        newMeta.setAttribute("content", color)
        document.head?.appendChild(newMeta)
    } else {
        metaThemeColor.setAttribute("content", color)
    }
}