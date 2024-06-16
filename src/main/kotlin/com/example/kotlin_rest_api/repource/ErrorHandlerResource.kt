package com.example.kotlin_rest_api.repource

import com.example.kotlin_rest_api.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice // в данному випадку використовується для хендлу помилки IllegalStateException, яка може виникнути в сервіс леєрі
class ErrorHandlerResource {

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(exc: IllegalStateException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(message = exc.localizedMessage))
    }

}