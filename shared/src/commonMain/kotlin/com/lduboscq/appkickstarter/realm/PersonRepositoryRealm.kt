package com.lduboscq.appkickstarter.realm

import com.lduboscq.appkickstarter.model.Person
import com.lduboscq.appkickstarter.model.PersonRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

abstract class PersonRepositoryRealm : PersonRepository{

    lateinit var realm: Realm

    private suspend fun convertToModelData(data: PersonRealmObject?): Person? {
        if (!this::realm.isInitialized){
            setupRealmSync()
        }
        var person: Person? = null
        if (data != null){
            realm.write {
                person = Person(
                    id = data._id,
                    name = data.name,
                    role = data.role,
                    imageUrl = data.imageUrl
                )
            }
        }
        return person
    }

    private suspend fun convertToModelData(data:RealmResults<PersonRealmObject>) : MutableList<Person>{
        var results = mutableListOf<Person>()
        for (personObject in data){
            val person : Person = Person(
                id = personObject._id,
                name = personObject.name,
                role = personObject.role,
                imageUrl = personObject.imageUrl
            )
            results.add(person)
        }
        return results
    }

    abstract suspend fun setupRealmSync()

    fun close(){
        realm.close()
    }

    override suspend fun getPerson(name: String): Person? {
        if (!this::realm.isInitialized){
            setupRealmSync()
        }
        var personRealmObject : PersonRealmObject? = realm.query<PersonRealmObject>(PersonRealmObject::class, "name = \"$name\"").first().find()

        return  convertToModelData(personRealmObject)
    }

    override suspend fun getPersons(): MutableList<Person> {
        if (!this::realm.isInitialized){
            setupRealmSync()
        }
        val personObjects : RealmResults<PersonRealmObject> = realm.query<PersonRealmObject>(PersonRealmObject::class).find()
        return convertToModelData(personObjects)
    }

    override suspend fun addPerson(person: Person) : Person? {
        if (!this::realm.isInitialized){
            setupRealmSync()
        }
        var personRealmObject : PersonRealmObject? = null
        realm.write{
             personRealmObject = copyToRealm(PersonRealmObject().apply {
                name = person.name
                role = person.role
                imageUrl = person.imageUrl
            })
        }
        return convertToModelData(personRealmObject)

    }

    override suspend fun deletePerson(id : String) {
        if (!this::realm.isInitialized){
            setupRealmSync()
        }
        var personRealmObject: PersonRealmObject? = realm.query<PersonRealmObject>(PersonRealmObject::class, "_id = \"$id\"").find().first()
        if (personRealmObject != null){
            realm.write {
                findLatest(personRealmObject)?.also { delete(it) }
            }
        }
    }

    override suspend fun updatePerson(person: Person) : Person {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        var personRealmObject: PersonRealmObject? = realm.query<PersonRealmObject>(
            PersonRealmObject::class,
            "_id = \"${person.id}\""
        ).find().first()
        if (personRealmObject != null) {
            realm.write {
                var newPerson = findLatest(personRealmObject!!)
                newPerson?.name = person.name
                newPerson?.role = person.role
                newPerson?.imageUrl = person.imageUrl
            }
        }
        return person
    }
}