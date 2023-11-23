package com.panierdantan.atlas_collections.produits

import com.panierdantan.atlas_collections.shops.Boutique
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

open class Produit : RealmObject {
    @PrimaryKey
    var _id: ObjectId = BsonObjectId()
    var boutiqueId: Boutique? = null
    var categorieId: CategoriesProduits? = null
    var nom: String = ""
    var disponibilite: Boolean = false
    var prix: Double = 0.0
    var rating: Double = 0.0
    var nbOfRating: Int = 0
    var isBio: Boolean = false
    var tags: RealmList<Tags> = realmListOf()
}