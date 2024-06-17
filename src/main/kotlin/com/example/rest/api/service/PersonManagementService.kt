package com.example.rest.api.service

import com.example.rest.api.dto.AddPersonRequest
import com.example.rest.api.dto.PersonResponse
import com.example.rest.api.repository.PersonRepository
import com.example.rest.api.domain.Person
import com.example.rest.api.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class PersonManagementService(
    private val personRepository: PersonRepository,
) {

    fun findById(id: Long): PersonResponse? {
        val person = this.findPersonById(id) ?: throw IllegalStateException(
            "Can't find person with id: id=${id}"
        )

        return person.toPersonResponse()
    }

    fun findAll(pageable: Pageable): Page<PersonResponse> =
        this.personRepository.findAll(pageable).map(Person::toPersonResponse)

    fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(
            addPersonRequest.toDomain()
        )
    }

    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException(
            "Can't find person with id: id=${updatePersonRequest.id}"
        )

        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    fun deleteById(id: Long): Unit {
        val person = this.findPersonById(id) ?: throw IllegalStateException(
            "Can't find person with id: id=${id}"
        )
        return this.personRepository.deleteById(person.id)
    }

    private fun findPersonById(id: Long): Person? = this.personRepository.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personRepository.save(person).toPersonResponse()
}