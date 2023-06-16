package com.lduboscq.appkickstarter.realm

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID
import io.realm.kotlin.types.annotations.PrimaryKey

class PersonRealmObject : RealmObject {
    @PrimaryKey
    var _id: String = RealmUUID.random().toString()
    var name: String = ""
    var role: String = ""
    var imageUrl : String = ""
}