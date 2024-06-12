package com.example.kotlin_rest_api.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator

// Домен, і в одночас модель бази даних
@Entity
data class Person(
    @Id
    @SequenceGenerator(
        name = PERSON_SEQUENCE, sequenceName = PERSON_SEQUENCE, initialValue = 1, allocationSize = 1
    )
    val id: Long = 1,
    var name: String = "",
    var lastName: String? = null
) {


    companion object {
        const val PERSON_SEQUENCE: String = "PERSON_SEQUENCE"
    }
}
