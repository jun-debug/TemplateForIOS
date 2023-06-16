package com.lduboscq.appkickstarter.model

import com.lduboscq.appkickstarter.Frog
import com.lduboscq.appkickstarter.FrogData
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    suspend fun getPerson(name: String) : Person?
    suspend fun getAllPerson() : Flow<Person>
    suspend fun addPerson(person: Person)
    suspend fun deletePerson(id: String)
    suspend fun updatePerson(person: Person)
}