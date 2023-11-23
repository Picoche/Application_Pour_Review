package com.panierdantan.auth.repositories

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

class AuthRepository {
    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

        @Singleton
        @Provides
        fun createRealmAppConfig(): App {
            return App.create("application-0-vlpzl")
        }

        @Singleton
        @Provides
        suspend fun LogInUser(app: App): RealmUser {
            val credentials = Credentials.emailPassword("hombert.fabien@gmail.com", "@Renouvier66")
            return app.login(credentials)
        }

        @Singleton
        @Provides
        fun provideRealmAppConfig(user: RealmUser): Realm {
            val config =
                SyncConfiguration.Builder(user, setOf(User::class, Produit::class, Boutique::class))
                    .build()

            return Realm.open(config)
        }

        fun closeThisRealm(realm: Realm) {
            realm.close()
        }
    }
}