package com.panierdantan.auth.repositories

import com.panierdantan.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import javax.inject.Singleton

class AuthRepository {
    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

        @Singleton
        @Provides
        fun provideRealmAppConfig() {
            val app = App.create("application-0-vlpzl")


        }
    }
}