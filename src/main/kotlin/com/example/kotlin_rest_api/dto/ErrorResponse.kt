package com.example.kotlin_rest_api.dto

import java.time.LocalDateTime

data class ErrorResponse(
    val title: String = "Bad request",
    var message: String?,
    val dateTime: LocalDateTime = LocalDateTime.now()
)