package com.panierdantan.models.produits

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

open class Tags(
    @PrimaryKey
    var _id: ObjectId = BsonObjectId(),
    var nom: String = ""
): RealmObject {
    constructor() : this(
        _id = BsonObjectId(),
        nom = ""
    )
}