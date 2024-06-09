package com.example.kotlin_rest_api.domain

data class Person(
    val id: Long = 1,
    var name: String = "",
    var lastName: String? = null,
)
