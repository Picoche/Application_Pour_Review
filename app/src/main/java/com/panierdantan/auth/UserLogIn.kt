package com.panierdantan.auth

import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.User

suspend fun UserLogIn(app: App): User {
    val credentials = Credentials.emailPassword("hombert.fabien@gmail.com", "@Renouvier66")
    val user = app.login(credentials)
    return user
}
//test