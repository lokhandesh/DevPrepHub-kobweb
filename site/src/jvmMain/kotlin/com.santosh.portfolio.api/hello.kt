package com.santosh.portfolio.api

import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.setBodyText

@Api
suspend fun hello(ctx: ApiContext) {
    ctx.res.setBodyText("👋 Hello World from API")
}