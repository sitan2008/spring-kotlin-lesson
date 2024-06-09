package com.example.kotlin_rest_api.service

import com.example.kotlin_rest_api.dto.AddPersonRequest
import com.example.kotlin_rest_api.dto.PersonResponse
import com.example.kotlin_rest_api.dao.PersonDao
import com.example.kotlin_rest_api.dto.UpdatePersonRequest
import com.example.kotlin_rest_api.transformer.AddPersonRequestTransformer
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(
    private val personDao: PersonDao,
    private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<PersonResponse> {
        TODO("Not yet implemented")
    }

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }
}