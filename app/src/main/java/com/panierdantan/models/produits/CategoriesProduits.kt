package com.panierdantan.models.produits

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

@Serializable
open class CategoriesProduits(
    @PrimaryKey
    var _id: ObjectId = BsonObjectId(),
    var nom: String = ""
): RealmObject {
    constructor() : this(
        _id = BsonObjectId(),
        nom = ""
    )
}