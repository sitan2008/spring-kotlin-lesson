package com.example.kotlin_rest_api.dto

data class UpdatePersonRequest(val id: Long, val name: String, val lastName: String? = null)
