package com.example.kotlin_rest_api.repource

import com.example.kotlin_rest_api.dto.AddPersonRequest
import com.example.kotlin_rest_api.dto.PersonResponse
import com.example.kotlin_rest_api.dto.UpdatePersonRequest
import org.springframework.http.ResponseEntity

// Інтерфейс рест контроллеру
interface PersonResource {
    fun findById(id: Long): ResponseEntity<PersonResponse?>
    fun findAll(): ResponseEntity<List<PersonResponse>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
}