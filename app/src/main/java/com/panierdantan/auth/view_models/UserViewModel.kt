package com.panierdantan.auth.view_models

import androidx.lifecycle.ViewModel
import com.panierdantan.R
import com.panierdantan.auth.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.AppConfiguration
import io.realm.kotlin.mongodb.User
import com.panierdantan.atlas_collections.accounts.User as Utilisateur
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repo: AuthRepository) : ViewModel() {

    val credentials = Credentials.emailPassword("hombert.fabien@gmail.com", "@Renouvier66")

    val user = MutableStateFlow<Utilisateur>(Utilisateur())

    // val user = app.login(credentials)
}