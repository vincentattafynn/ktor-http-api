package com.example.controller

import com.example.models.CreateCustomerDto
import io.ktor.http.cio.*

interface CustomerController {
    fun createCustomer(createCustomerDto: CreateCustomerDto): Response
    fun getAllCustomers(): List<Response>
}