package com.example.kotlin_rest_api

import com.example.kotlin_rest_api.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class KotlinRestApiApplication {

    @GetMapping
    fun hi(): Person {
        return Person(
            name = "Oleksandr",
            lastName = "Furinets",
        )
    }
}


fun main(args: Array<String>) {
    runApplication<KotlinRestApiApplication>(*args)
}
