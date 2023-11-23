package com.panierdantan.auth.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panierdantan.atlas_collections.shops.Boutique
import com.panierdantan.auth.repositories.AuthRepository
import com.panierdantan.auth.repositories.AuthRepository.AppModule
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.User
import io.realm.kotlin.query.RealmResults
import com.panierdantan.atlas_collections.accounts.User as Utilisateur
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {

    val app = AppModule.createRealmAppConfig()

    val userId = MutableStateFlow<Int>(0)
    val user = MutableStateFlow<Utilisateur>(Utilisateur())

    fun logInUser(app: App) {
        viewModelScope.launch {
            val userToLogIn = AppModule.LogInUser(app)
            userId.value = userToLogIn.id.toInt()
            val realm = AppModule.provideRealmAppConfig(userToLogIn)

            user.value = realm.write {
                realm.query<Utilisateur>(Utilisateur::class).equalTo("id", userId.value).findFirst()!!
            }
        }
    }

    // val user = app.login(credentials)
}