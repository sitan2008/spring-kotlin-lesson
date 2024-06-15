package com.example.kotlin_rest_api.service

import com.example.kotlin_rest_api.dto.AddPersonRequest
import com.example.kotlin_rest_api.dto.PersonResponse
import com.example.kotlin_rest_api.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

// Service Layer Interface, тут проходить робота з бізнес-логікою, а також з Dao/Repository які відповідають за взаємодію з БД
interface PersonManagementService {
    fun findById(id: Long): PersonResponse?
    fun findAll(pageable: Pageable): Page<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long): Unit
}