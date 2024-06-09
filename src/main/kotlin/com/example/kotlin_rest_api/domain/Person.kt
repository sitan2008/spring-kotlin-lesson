package com.example.kotlin_rest_api.domain

data class Person(
    val id: Long = 1,
    val name: String = "",
    val lastName: String? = null,
)
