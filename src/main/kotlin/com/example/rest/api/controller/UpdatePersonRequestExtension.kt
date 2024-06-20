package com.example.rest.api.controller

import com.example.rest.api.domain.Person
import com.example.rest.api.dto.UpdatePersonRequest

fun UpdatePersonRequest?.toDomain(): Person {
    return Person(
        id = this?.id ?: 1L,
        name = this?.name ?: "",
        lastName = this?.lastName,
    )
}