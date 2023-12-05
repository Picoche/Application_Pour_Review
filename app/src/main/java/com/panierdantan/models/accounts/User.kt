package com.panierdantan.models.accounts

import com.panierdantan.models.shops.Boutique
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.serializers.RealmListKSerializer
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

@Serializable
open class User(
    @PrimaryKey
    var _id: ObjectId = BsonObjectId(),
    var email: String = "",
    var hash: String = "",
    var realmUserId: String = "",
    var estCommercant: Boolean? = false,
    var fullName: String = "",
    var profilePicture: String? = "",
    var pseudo: String = "",
    var adresse: String = "",

    @Serializable(RealmListKSerializer::class)
    var boutiques: RealmList<Boutique> = realmListOf()
): RealmObject {
    constructor() : this(
        _id = BsonObjectId(),
        email = "",
        hash = "",
        realmUserId = "",
        estCommercant = false,
        fullName = "",
        profilePicture = "",
        pseudo = "",
        adresse = "",
        boutiques = realmListOf()
    )
}