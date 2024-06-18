package com.example.rest.api.service

import com.example.rest.api.domain.Person
import com.example.rest.api.dto.AddPersonRequest

fun AddPersonRequest?.toDomain(): Person {
    return Person(
        name = this?.name ?: "",
        lastName = this?.lastName,
    )
}