package com.panierdantan.atlas_collections.shops

import com.panierdantan.atlas_collections.accounts.User
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import com.panierdantan.atlas_collections.produits.Produit as Produits


open class Boutique : RealmObject {
    @PrimaryKey
    var _id: ObjectId = BsonObjectId()
    var adresse: String = ""
    var categorieId: CategoriesBoutique? = null
    var commercantId: User? = null
    var nbOfRating: Double = 0.0
    var nom: String = ""
    var numTel: String = ""
    var openDays: String = ""
    var produits: RealmList<Produits> = realmListOf()
    var rating: Double = 0.0
}