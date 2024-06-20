package com.example.rest.api.service

import com.example.rest.api.controller.toPersonResponse
import com.example.rest.api.dto.PersonResponse
import com.example.rest.api.repository.PersonRepository
import com.example.rest.api.domain.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class PersonManagementService(
    private val personRepository: PersonRepository,
) {

    fun findById(id: Long): PersonResponse = this.findPersonById(id).toPersonResponse()

    fun findAll(pageable: Pageable): Page<PersonResponse> =
        this.personRepository.findAll(pageable).map(Person::toPersonResponse)

    fun save(addPersonRequest: Person): PersonResponse = this.saveOrUpdate(addPersonRequest)

    fun update(updatePersonRequest: Person): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id)

        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    fun deleteById(id: Long) {
        return this.personRepository.deleteById(this.findPersonById(id).id)
    }

    private fun findPersonById(id: Long): Person {
        val person: Person = this.personRepository.findByIdOrNull(id) ?: throw IllegalStateException(
            "Can't find person with id: id=${id}"
        )
        return person
    }

    private fun saveOrUpdate(person: Person): PersonResponse = this.personRepository.save(person).toPersonResponse()
}