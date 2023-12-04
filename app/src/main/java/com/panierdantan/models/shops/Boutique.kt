package com.panierdantan.models.shops

import com.panierdantan.models.accounts.User
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import com.panierdantan.models.produits.Produit as Produits

@Serializable
open class Boutique(
    @PrimaryKey
    var _id: String = "",
    var adresse: String = "",
    var categorieId: CategoriesBoutique? = null,
    var commercantId: User? = null,
    var nbOfRating: Double = 0.0,
    var nom: String = "",
    var numTel: String = "",
    var openDays: String = "",
    //var produits: RealmList<Produits> = realmListOf(),
    var rating: Double = 0.0
): RealmObject {}