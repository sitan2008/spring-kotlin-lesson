package com.example.kotlin_rest_api.transformer

import com.example.kotlin_rest_api.domain.Person
import com.example.kotlin_rest_api.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer : Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
            name = source.name,
            lastName = source.lastName,
        )
    }
}