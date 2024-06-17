package com.example.rest.api.domain

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person(
    @Id
    @SequenceGenerator(
        name = PERSON_SEQUENCE, sequenceName = PERSON_SEQUENCE, initialValue = 1, allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PERSON_SEQUENCE)
    @Column(name = "id")
    val id: Long = 1,
    @Column(name = "name", nullable = false)
    var name: String = "",
    @Column(name = "last_name", nullable = true)
    var lastName: String? = null
) {

    companion object {
        const val PERSON_SEQUENCE: String = "PERSON_SEQUENCE"
    }
}
