package com.example.kotlin_rest_api.service

import com.example.kotlin_rest_api.dto.AddPersonRequest
import com.example.kotlin_rest_api.dto.PersonResponse
import com.example.kotlin_rest_api.dao.PersonDao
import com.example.kotlin_rest_api.domain.Person
import com.example.kotlin_rest_api.dto.UpdatePersonRequest
import com.example.kotlin_rest_api.transformer.AddPersonRequestTransformer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


//Імплементація PersonManagementService
@Service
class PersonManagementServiceImpl(
    private val personDao: PersonDao, private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? {
        val person = this.findPersonById(id) ?: throw IllegalStateException(
            "Can't find person with id: id=${id}"
        )

        return person.toPersonResponse()
    }

    override fun findAll(pageable: Pageable): Page<PersonResponse> =
        this.personDao.findAll(pageable).map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(
            addPersonRequestTransformer.transform(addPersonRequest)
        )
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException(
            "Can't find person with id: id=${updatePersonRequest.id}"
        )

        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long): Unit {
        val person = this.findPersonById(id) ?: throw IllegalStateException(
            "Can't find person with id: id=${id}"
        )
        return this.personDao.deleteById(person.id)
    }

    private fun findPersonById(id: Long): Person? = this.personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}