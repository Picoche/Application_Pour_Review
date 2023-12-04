package com.panierdantan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.panierdantan.view_models.DataViewModel
import com.panierdantan.auth.view_models.LoginViewModel
import com.panierdantan.screens.HomePage
import com.panierdantan.ui.theme.PanierDAntanTheme
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration

lateinit var app: App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = App.create(
            AppConfiguration.Builder(getString(R.string.realm_app_id))
                .appName(getString(R.string.app_name))
                .baseUrl(getString(R.string.realm_base_url))
                .build())
        setContent {
            val viewModel = LoginViewModel()
            val dataModel = DataViewModel()
            PanierDAntanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomePage(viewModel, dataModel)
                }
            }
        }
    }
}