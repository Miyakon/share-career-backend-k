package com.example.plugins

import com.example.domain.Id
import com.example.gateway.UserGateway
import com.example.usecase.UserUseCase
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        route("/v1") {
            get("/users/{userId}") {
                val userId = call.parameters["userId"]!!.toInt()
                val userGateway = UserGateway()
                val userUseCase = UserUseCase(userGateway)
                val user = userUseCase.getUserbyId(Id(userId))
                call.respondText("Hello ${ user!!.name.value}\n")
            }
            get("/systems/ping") {
                call.respondText("pong\n")
            }
        }
    }
}