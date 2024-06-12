package com.example.kotlin_rest_api.repource

import com.example.kotlin_rest_api.dto.AddPersonRequest
import com.example.kotlin_rest_api.dto.PersonResponse
import com.example.kotlin_rest_api.dto.UpdatePersonRequest
import com.example.kotlin_rest_api.repource.PersonResourceImpl.Companion.BASE_PERSON_URL
import com.example.kotlin_rest_api.service.PersonManagementService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

// Вказуємо Spring що цей клас - рест контроллер
@RestController
// Вказуємо шлях до ресурсу за який відповідає цей рест контроллер
@RequestMapping(value = [BASE_PERSON_URL])
// Імплементація PersonResource
class PersonResourceImpl(
    private val personManagementService: PersonManagementService
) : PersonResource {

    // <Get, Post, Path, Delete>_Mapping вказуємо які саме методи класу відповідають за певний http method
    @GetMapping("/{id}") // Ідентифікатор ресурсу
    override fun findById(@PathVariable id: Long): ResponseEntity<PersonResponse?> {
        return ResponseEntity.status(HttpStatus.OK).body(this.personManagementService.findById(id))
    }

    @GetMapping("/")
    override fun findAll(): ResponseEntity<List<PersonResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(this.personManagementService.findAll())
    }


    @PostMapping // @RequestBody вказує Spring що потрібно розпарсити body запиту, та прокинути його в аргумент методу
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        val personResponse = this.personManagementService.save(addPersonRequest)
        return ResponseEntity.created(URI.create(BASE_PERSON_URL.plus("/${personResponse.id}"))).body(personResponse)
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(this.personManagementService.update(updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.personManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}