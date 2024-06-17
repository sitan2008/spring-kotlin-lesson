package com.example.rest.api.controller

import com.example.rest.api.dto.AddPersonRequest
import com.example.rest.api.dto.PersonResponse
import com.example.rest.api.dto.UpdatePersonRequest
import com.example.rest.api.controller.PersonController.Companion.BASE_PERSON_URL
import com.example.rest.api.service.PersonManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonController(
    private val personManagementService: PersonManagementService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<PersonResponse?> {
        return ResponseEntity.status(HttpStatus.OK).body(this.personManagementService.findById(id))
    }

    @GetMapping("")
    fun findAll(pageable: Pageable): ResponseEntity<Page<PersonResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(this.personManagementService.findAll(pageable))
    }

    @PostMapping
    fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        val personResponse = this.personManagementService.save(addPersonRequest)
        return ResponseEntity.created(URI.create(BASE_PERSON_URL.plus("/${personResponse.id}"))).body(personResponse)
    }

    @PutMapping
    fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(this.personManagementService.update(updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.personManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}