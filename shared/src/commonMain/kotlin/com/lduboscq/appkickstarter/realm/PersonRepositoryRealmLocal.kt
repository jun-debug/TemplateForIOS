package com.lduboscq.appkickstarter.realm

import com.lduboscq.appkickstarter.Frog
import com.lduboscq.appkickstarter.model.Person
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class PersonRepositoryRealmLocal : PersonRepositoryRealm() {
    override suspend fun setupRealmSync() {
        val config = RealmConfiguration.Builder(setOf(PersonRealmObject::class))
            .build()
        realm = Realm.open(config)
    }
}