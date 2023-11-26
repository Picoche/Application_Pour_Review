package com.panierdantan.auth.view_models

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.panierdantan.app
import com.panierdantan.atlas_collections.accounts.User
import com.panierdantan.auth.repositories.AuthRepository
import com.panierdantan.auth.repositories.RealmAuthRepository
import io.realm.kotlin.annotations.ExperimentalRealmSerializerApi
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.exceptions.ConnectionException
import io.realm.kotlin.mongodb.exceptions.InvalidCredentialsException
import io.realm.kotlin.mongodb.exceptions.UserAlreadyExistsException
import io.realm.kotlin.mongodb.ext.customData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

/**
 * Types of UX events triggered by user actions.
 */
sealed class LoginEvent(val severity: EventSeverity, val message: String) {
    class GoToTasks(severity: EventSeverity, message: String) : LoginEvent(severity, message)
    class ShowMessage(severity: EventSeverity, message: String) : LoginEvent(severity, message)
}

/**
 * Severity of the event.
 */
enum class EventSeverity {
    INFO, ERROR
}

/**
 * Users can either create accounts or log in with an existing one.
 */
enum class LoginAction {
    LOGIN, CREATE_ACCOUNT
}

/**
 * UI representation of a screen state.
 */
data class LoginState(
    val action: LoginAction,
    val email: String = "",
    val password: String = "",
    val enabled: Boolean = true
) {
    companion object {
        /**
         * Initial UI state of the login screen.
         */
        val initialState = LoginState(action = LoginAction.LOGIN)
    }
}

class LoginViewModel : ViewModel() {

    private val _state: MutableState<LoginState> = mutableStateOf(LoginState.initialState)
    val state: State<LoginState>
        get() = _state

    private val _event: MutableSharedFlow<LoginEvent> = MutableSharedFlow()
    val event: Flow<LoginEvent>
        get() = _event

    private val _user: MutableState<User> = mutableStateOf(User())
    val user: State<User>
        get() = _user

    private val authRepository: AuthRepository = RealmAuthRepository

    fun switchToAction(loginAction: LoginAction) {
        _state.value = state.value.copy(action = loginAction)
    }

    fun setEmail(email: String) {
        _state.value = state.value.copy(email = email)
    }

    fun setPassword(password: String) {
        _state.value = state.value.copy(password = password)
    }

    fun createAccount(email: String, password: String) {
        _state.value = state.value.copy(enabled = false)

        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                authRepository.createAccount(email, password)
            }.onSuccess {
                _event.emit(LoginEvent.ShowMessage(EventSeverity.INFO, "Compte créé avec succès."))
                login(email, password)
            }.onFailure { ex: Throwable ->
                _state.value = state.value.copy(enabled = true)
                val message = when (ex) {
                    is UserAlreadyExistsException -> "Erreur lors de l'inscription : un compte relié à l'adresse ${_state.value.email} existe déjà."
                    else -> "Erreur lors de l'inscription: ${ex.message}"
                }
                _event.emit(LoginEvent.ShowMessage(EventSeverity.ERROR, message))
            }
        }
    }

    fun login(email: String, password: String, fromCreation: Boolean = false) {
        if (!fromCreation) {
            _state.value = state.value.copy(enabled = false)
        }
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                app.login(Credentials.emailPassword(email, password))
                _state.value = state.value.copy(email = email, password = password)
            }.onSuccess {
                _event.emit(
                    LoginEvent.GoToTasks(
                        EventSeverity.INFO,
                        "Connexion réussie."
                    )
                )
            }.onFailure { ex: Throwable ->
                _state.value = state.value.copy(enabled = true)
                val message = when (ex) {
                    is InvalidCredentialsException -> "Identifiant ou mot de passe invalide. Veuillez réessayer."
                    is ConnectionException -> "Impossible de se connecter au serveur d'authentification. Veuillez vérifier votre connexion Internet et réessayer."
                    else -> "Erreur: $ex"
                }
                _event.emit(LoginEvent.ShowMessage(EventSeverity.ERROR, message))
            }
        }
    }

    @OptIn(ExperimentalRealmSerializerApi::class)
    fun customLogin(email: String, password: String, fromCreation: Boolean = false) {
        if (!fromCreation) {
            _state.value = state.value.copy(enabled = false)
        }

        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                app.login(Credentials.customFunction(payload = mapOf("email" to email, "password" to password)))
            }.onSuccess {
                _event.emit(
                    LoginEvent.GoToTasks(
                        EventSeverity.INFO,
                        "Connexion réussie."
                    )
                )
                _user.value = app.currentUser!!.customData<User>()!!
            }.onFailure { ex: Throwable ->
                _state.value = state.value.copy(enabled = true)
                val message = when (ex) {
                    is InvalidCredentialsException -> "Identifiant ou mot de passe invalide. Veuillez réessayer."
                    is ConnectionException -> "Impossible de se connecter au serveur d'authentification. Veuillez vérifier votre connexion Internet et réessayer."
                    else -> "Erreur: $ex"
                }
                _event.emit(LoginEvent.ShowMessage(EventSeverity.ERROR, message))
            }
        }
    }
}