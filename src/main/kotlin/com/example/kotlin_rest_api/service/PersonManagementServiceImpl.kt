package com.example.kotlin_rest_api.service

import com.example.kotlin_rest_api.dto.AddPersonRequest
import com.example.kotlin_rest_api.dto.PersonResponse
import com.example.kotlin_rest_api.dao.PersonRepository
import com.example.kotlin_rest_api.domain.Person
import com.example.kotlin_rest_api.dto.UpdatePersonRequest
import com.example.kotlin_rest_api.transformer.AddPersonRequestTransformer
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(
    private val personRepository: PersonRepository,
    private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? = this.findPersonById(id).toPersonResponse()

    override fun findAll(): List<PersonResponse> = this.personRepository.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(
            addPersonRequestTransformer.transform(addPersonRequest)
        )
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException(
            "Can't find person with id: id=${updatePersonRequest.id}"
        )

        return this.saveOrUpdate(
            person.apply {
                this.name = updatePersonRequest.name
                this.lastName = updatePersonRequest.lastName
            }
        )
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    private fun findPersonById(id: Long): Person? = this.personRepository.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personRepository.save(person).toPersonResponse()
}