package com.example.plugins

import com.example.driver.UserDriver
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            val driver = UserDriver()
            val name = driver.connection()
            call.respondText("Hello ${name}!\n")
        }
        get("/v1/systems/ping") {
            call.respondText("pong\n")
        }
    }
}