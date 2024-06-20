package com.example.rest.api.controller

import com.example.rest.api.domain.Person
import com.example.rest.api.dto.PersonResponse


fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
        id = this?.id ?: 1L,
        fullName = "${this?.name} ${this?.lastName}",
    )
}