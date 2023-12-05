package com.panierdantan.models.produits

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
open class Produits(
    @PrimaryKey
    var _id: ObjectId = BsonObjectId(),
    var boutiqueId: Boutique? = null,
    var categorieId: CategoriesProduits? = null,
    var nom: String = "",
    var disponibilite: Boolean? = false,
    var prix: Double = 0.0,
    var rating: Double? = 0.0,
    var nbOfRating: Int? = 0,
    var isBio: Boolean = false,

    @Serializable(RealmListKSerializer::class)
    var tags: RealmList<Tags> = realmListOf()
): RealmObject {
    constructor() : this(
        _id = BsonObjectId(),
        boutiqueId = null,
        categorieId = null,
        nom = "",
        disponibilite = false,
        prix = 0.0,
        rating = 0.0,
        nbOfRating = 0,
        isBio = false,
        tags = realmListOf()
    )
}