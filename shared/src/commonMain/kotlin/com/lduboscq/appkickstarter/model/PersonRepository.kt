package com.lduboscq.appkickstarter.model

import com.lduboscq.appkickstarter.Frog
import com.lduboscq.appkickstarter.FrogData

interface PersonRepository {
    suspend fun getPerson(name: String) : Person?
    suspend fun getAllPerson() : ArrayList<Person>
    suspend fun addPerson(person: Person)
    suspend fun deletePerson(name: String)
    suspend fun updatePerson(person: Person)
}