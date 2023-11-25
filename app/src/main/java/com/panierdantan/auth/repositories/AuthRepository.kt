package com.panierdantan.auth.repositories

import com.panierdantan.app
import io.realm.kotlin.mongodb.User as RealmUser
import com.panierdantan.atlas_collections.accounts.User
import com.panierdantan.atlas_collections.produits.Produit
import com.panierdantan.atlas_collections.shops.Boutique
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import javax.inject.Singleton

/**
 * Repository allowing users to create accounts or log in to the app with an existing account.
 */
interface AuthRepository {
    /**
     * Creates an account with the specified [email] and [password].
     */
    suspend fun createAccount(email: String, password: String)

    /**
     * Logs in with the specified [email] and [password].
     */
    suspend fun login(email: String, password: String)
}

/**
 * [AuthRepository] for authenticating with MongoDB.
 */
object RealmAuthRepository : AuthRepository {
    override suspend fun createAccount(email: String, password: String) {
        app.emailPasswordAuth.registerUser(email, password)
    }

    override suspend fun login(email: String, password: String) {
        app.login(Credentials.emailPassword(email, password))
    }
}