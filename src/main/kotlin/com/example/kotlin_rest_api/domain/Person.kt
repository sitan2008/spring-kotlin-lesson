package com.example.kotlin_rest_api.domain

import jakarta.persistence.Entity

@Entity
data class Person(
    val id: Long = 1,
    var name: String = "",
    var lastName: String? = null,
)
