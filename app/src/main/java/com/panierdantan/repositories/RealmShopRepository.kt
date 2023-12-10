package com.panierdantan.repositories

import com.panierdantan.app
import com.panierdantan.models.produits.CategoriesProduits
import com.panierdantan.models.produits.Produits
import com.panierdantan.models.produits.Tags
import com.panierdantan.models.shops.Boutique
import com.panierdantan.models.shops.CategoriesBoutique
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.mongodb.User
import com.panierdantan.models.accounts.User as Utilisateur
import io.realm.kotlin.mongodb.subscriptions
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import io.realm.kotlin.mongodb.syncSession
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * Repository for accessing Realm Sync.
 */
interface ShopSyncRepository {

    /**
     * Returns a flow with the tasks for the current subscription.
     */
    fun getShopList(): Collection<Boutique>

    /**
     * Adds a task that belongs to the current user using the specified [taskSummary].
     */
    suspend fun addShop(boutique: Boutique)

    /**
     * Deletes a given task.
     */
    // suspend fun deleteTask(task: Item)

    /**
     * Pauses synchronization with MongoDB. This is used to emulate a scenario of no connectivity.
     */
    fun pauseSync()

    /**
     * Resumes synchronization with MongoDB.
     */
    fun resumeSync()

    /**
     * Closes the realm instance held by this repository.
     */
    fun close()
}

/**
 * Repo implementation used in runtime.
 */
class RealmShopRepository() : ShopSyncRepository {

    private val realm: Realm
    private val config: SyncConfiguration
    private val currentUser: User
        get() = app.currentUser!!

    init {
        config = SyncConfiguration.create(
            currentUser, setOf(
                Utilisateur::class,
                Produits::class,
                CategoriesProduits::class,
                Tags::class,
                Boutique::class,
                CategoriesBoutique::class
            )
        )

        realm = Realm.open(config)

        // Mutable states must be updated on the UI thread
        CoroutineScope(Dispatchers.Main).launch {
            realm.subscriptions.waitForSynchronization()
        }
    }

    override fun getShopList(): List<Boutique> {
        return realm.query<Boutique>().find()
    }

    override suspend fun addShop(boutique: Boutique) {
        val shop = Boutique().apply {
            this.adresse = boutique.adresse
        }
        realm.write {
            copyToRealm(shop)
        }
    }

    /*override suspend fun deleteTask(task: Item) {
        realm.write {
            delete(findLatest(task)!!)
        }
        realm.subscriptions.waitForSynchronization(10.seconds)
    }*/

    override fun pauseSync() {
        realm.syncSession.pause()
    }

    override fun resumeSync() {
        realm.syncSession.resume()
    }

    override fun close() = realm.close()
}