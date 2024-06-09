package com.example.kotlin_rest_api.service

import com.example.kotlin_rest_api.domain.Person
import com.example.kotlin_rest_api.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
        id = this?.id ?: 1L,
        fullName = "${this?.name} ${this?.lastName}",
    )
}