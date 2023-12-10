package com.panierdantan.models.accounts

import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import io.realm.kotlin.types.RealmObject

@Serializable
open class User(
    @PrimaryKey
    var _id: String = "",
    var email: String = "",
    var hash: String = "",
    var realmUserId: String = "",
    var estCommercant: Boolean? = false,
    var fullName: String = "",
    var profilePicture: String? = "",
    var pseudo: String = "",
    var adresse: String = "",
): RealmObject {
    constructor() : this(
        _id = "",
        email = "",
        hash = "",
        realmUserId = "",
        estCommercant = false,
        fullName = "",
        profilePicture = "",
        pseudo = "",
        adresse = "",
    )
}