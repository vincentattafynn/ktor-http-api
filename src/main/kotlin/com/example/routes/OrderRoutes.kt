package com.example.routes

import io.ktor.server.routing.*
import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*


fun Route.orderRouting() {
    route("/order"){
        post {
            val Order = call.receive<Order>()
            orderStorage.add(Order)
            call.respondText("Order stored correctly", status = HttpStatusCode.Created)
        }
        get("/all") {
            if (orderStorage.isNotEmpty()) {
                call.respond(orderStorage)
            }
        }
        get("/{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
            val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
                "Not Found",
                status = HttpStatusCode.NotFound
            )
            call.respond(order)
        }
    }
}

fun Route.totalizeOrderRoute() {
    get("/order/{id?}/total") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        val total = order.contents.sumOf { it.price * it.amount }
        call.respond(total)
    }
}