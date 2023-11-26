package com.panierdantan.atlas_collections.produits

import com.panierdantan.atlas_collections.shops.Boutique
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

open class CategoriesProduits : RealmObject {
    @PrimaryKey
    var _id: ObjectId = BsonObjectId()
    var nom: String = ""
}