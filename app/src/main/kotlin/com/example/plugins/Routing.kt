package com.example.plugins

import com.example.driver.UserDriver
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        route("/v1") {
            get("/users/{userId}") {
            val driver = UserDriver()
            val name = driver.connection(1)
            call.respondText("Hello ${name}!\n")
            }
            get("/systems/ping") {
                call.respondText("pong\n")
            }
        }
    }
}