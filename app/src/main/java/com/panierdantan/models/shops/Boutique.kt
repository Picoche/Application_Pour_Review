package com.panierdantan.models.shops

import com.panierdantan.models.accounts.User
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.serializers.RealmListKSerializer
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import com.panierdantan.models.produits.Produits

@Serializable
open class Boutique(
    @PrimaryKey
    var _id: ObjectId = BsonObjectId(),
    var adresse: String = "",
    var categorieId: CategoriesBoutique? = null,
    var commercantId: User? = null,
    var nbOfRating: Double = 0.0,
    var nom: String = "",
    var numTel: String = "",
    var openDays: String = "",

    @Serializable(RealmListKSerializer::class)
    var produits: RealmList<Produits> = realmListOf(),
    var rating: Double = 0.0
): RealmObject {
    constructor() : this(
        _id = BsonObjectId(),
        adresse = "",
        categorieId = null,
        commercantId = null,
        nbOfRating = 0.0,
        nom = "",
        numTel = "",
        openDays = "",
        produits = realmListOf(),
        rating = 0.0
    )
}