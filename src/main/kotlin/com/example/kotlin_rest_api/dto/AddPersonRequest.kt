package com.example.kotlin_rest_api.dto

data class AddPersonRequest(val name: String, val lastName: String? = null)
