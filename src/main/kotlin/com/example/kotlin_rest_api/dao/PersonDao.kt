package com.example.kotlin_rest_api.dao

import com.example.kotlin_rest_api.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// Dao/Repository відповідає за роботу з БД та інкапсулює її від Service Layer
@Repository
interface PersonDao : JpaRepository<Person, Long>