package com.example.kotlin_rest_api.dao

import com.example.kotlin_rest_api.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao : JpaRepository<Person, Long>