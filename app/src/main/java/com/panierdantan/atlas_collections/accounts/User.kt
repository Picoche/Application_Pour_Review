package com.panierdantan.atlas_collections.accounts

import com.panierdantan.atlas_collections.shops.Boutique
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.serializers.RealmListKSerializer
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import org.mongodb.kbson.ObjectId

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
    var roles: Array<String> = arrayOf(),

    @Serializable(RealmListKSerializer::class)
    var boutiques: RealmList<ObjectId> = realmListOf()
): RealmObject {}