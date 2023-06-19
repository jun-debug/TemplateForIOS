package com.lduboscq.appkickstarter.model

interface PersonRepository {
    suspend fun getPerson(name: String) : Person?
    suspend fun getPersons() : MutableList<Person>
    suspend fun addPerson(person: Person) : Person?
    suspend fun deletePerson(id: String)
    suspend fun updatePerson(person: Person) : Person
}