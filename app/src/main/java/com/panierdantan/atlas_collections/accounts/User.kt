package com.panierdantan.atlas_collections.accounts

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import java.util.Date

@Serializable
open class User(
    @PrimaryKey
    var _id: ObjectId = ObjectId(),
    var email: String = "",
    var hash: String = "",
    var realmUserId: String = "",
    //var adresse: String = "",

    @Serializable(DateSerializer::class)
    var createdAt: Date = Date(),

    var estCommercant: Boolean? = null,
    var fullName: String = "",
    var profilePicture: String? = null,
    var pseudo: String = ""
): RealmObject {}