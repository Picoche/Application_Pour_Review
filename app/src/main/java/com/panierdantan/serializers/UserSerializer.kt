package com.panierdantan.serializers

import android.util.Log
import com.panierdantan.atlas_collections.accounts.User
import kotlinx.serialization.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import org.mongodb.kbson.ObjectId
import java.text.SimpleDateFormat
import java.util.*
/*@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = User::class)
object UserSerializer : KSerializer<User> {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US)

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: User) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value._id.toString())
            encodeStringElement(descriptor, 1, value.email)
            encodeStringElement(descriptor, 2, value.hash)
            encodeStringElement(descriptor, 3, value.realmUserId)
            encodeNullableSerializableElement(
                descriptor,
                4,
                Boolean.serializer(),
                value.estCommercant
            )
            encodeStringElement(descriptor, 5, value.fullName)
            encodeNullableSerializableElement(
                descriptor,
                6,
                String.serializer(),
                value.profilePicture
            )
            encodeStringElement(descriptor, 7, value.pseudo)
            encodeStringElement(descriptor, 8, value.adresse)
            // Add more encode calls for additional fields if needed
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): User {
        Log.d("UserSerializer", "descriptor: ${descriptor.serialName}")
        return decoder.decodeStructure(descriptor) {
            var id = ""
            var email = ""
            var hash = ""
            var realmUserId = ""
            var estCommercant: Boolean? = null
            var fullName = ""
            var profilePicture: String? = null
            var pseudo = ""
            var adresse = ""

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    CompositeDecoder.DECODE_DONE -> break
                    0 -> id = decodeStringElement(descriptor, index)
                    1 -> email = decodeStringElement(descriptor, index)
                    2 -> hash = decodeStringElement(descriptor, index)
                    3 -> realmUserId = decodeStringElement(descriptor, index)
                    4 -> estCommercant =
                        decodeNullableSerializableElement(descriptor, index, Boolean.serializer())

                    5 -> fullName = decodeStringElement(descriptor, index)
                    6 -> profilePicture =
                        decodeNullableSerializableElement(descriptor, index, String.serializer())

                    7 -> pseudo = decodeStringElement(descriptor, index)
                    8 -> adresse = decodeStringElement(descriptor, index)
                    // Add more decode calls for additional fields if needed
                    else -> error("Unexpected index: $index")
                }
            }

            User(

                _id = ObjectId(id),
                email = email,
                hash = hash,
                realmUserId = realmUserId,
                estCommercant = estCommercant,
                fullName = fullName,
                profilePicture = profilePicture,
                pseudo = pseudo,
                adresse = adresse
                // Add more field assignments if needed
            )
        }
    }
}*/