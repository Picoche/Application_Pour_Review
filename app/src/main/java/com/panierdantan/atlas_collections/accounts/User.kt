package com.panierdantan.atlas_collections.accounts

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import java.util.Date

open class User : RealmObject {
    @PrimaryKey
    var _id: ObjectId = BsonObjectId()
    var adresse: String = ""
    var createdAt: Date = Date()
    var email: String = ""
    var fullName: String = ""
    var password: String = ""
    var profilePicture: String = ""
    var pseudo: String = ""
    var estCommercant: Boolean = false
}