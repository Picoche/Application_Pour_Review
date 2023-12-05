package com.panierdantan.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


import com.panierdantan.Destination
import com.panierdantan.R
import com.panierdantan.repositories.RealmShopRepository
import com.panierdantan.auth.view_models.LoginViewModel
import com.panierdantan.custom_icons.UserIcon
import com.panierdantan.models.shops.Boutique
import com.panierdantan.screens.commercant.shops.DetailBoutiquesView
import com.panierdantan.screens.commercant.shops.FormAjoutProduitView
import com.panierdantan.screens.commercant.shops.FormCreationBoutiqueView
import com.panierdantan.screens.commercant.shops.FormModificationBoutiqueView
import com.panierdantan.screens.commercant.shops.MesBoutiquesView
import com.panierdantan.screens.commercant.shops.ScanneurQrCodeView
import com.panierdantan.screens.user.MesFavoris
import com.panierdantan.screens.user.MonPanier
import com.panierdantan.screens.user.MonProfil
import com.panierdantan.screens.user.shops.DetailProduitView
import com.panierdantan.view_models.DataViewModel
import org.mongodb.kbson.BsonObjectId


val unboundedFamily = FontFamily(
    Font(R.font.unbounded_light, FontWeight.Light),
    Font(R.font.unbounded_regular, FontWeight.Normal),
    Font(R.font.unbounded_medium, FontWeight.Medium),
    Font(R.font.unbounded_bold, FontWeight.Bold)
)
val robotoFamily = FontFamily(
    Font(R.font.roboto, FontWeight.Light),
    Font(R.font.roboto, FontWeight.Normal),
    Font(R.font.roboto, FontWeight.Medium),
    Font(R.font.roboto, FontWeight.Bold)
)
@Composable
fun HomePage(loginViewModel: LoginViewModel, dataViewModel: DataViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val destinations = listOf(
        Destination.VueBoutiques,
        Destination.VuePanier,
        Destination.VueFavoris,
        Destination.VueProfil
    )

    val user = loginViewModel.user.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = user.email,
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = unboundedFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                backgroundColor = Color(0xFF336699),
                elevation = 0.dp,
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                loginViewModel.customLogin("hombert.fabien@gmail.com", "Renouvier66")
                dataViewModel.addShop(Boutique(BsonObjectId(), "Beverly Hills"))
            }) {
                Icon(Icons.UserIcon, contentDescription = "Switch Users")
            }
        },
        bottomBar = {
            // if (currentDestination?.route != Destination.Profil.destination)
            BottomNavigation(
                Modifier
                    .navigationBarsPadding()
                    .background(SolidColor(Color(0xFF336699))),
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
                elevation = 0.dp,
            ) {
                destinations.forEach { screen ->
                    BottomNavigationItem(
                        selected =
                        currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                        selectedContentColor = Color(0xFFFF9914),
                        unselectedContentColor = Color.White,
                        icon = { Icon(screen.icon, contentDescription = null) },
                        onClick = { navController.navigate(screen.destination) })
                }
            }
        }) { innerPadding ->
        NavHost(
            navController, startDestination = Destination.VueBoutiques.destination,
            Modifier.padding(innerPadding)
        ) {
            composable("vue_boutiques") {
                MesBoutiquesView(
                    onClickAdd = { navController.navigate("creation_boutique") },
                    onClickBoutique = { navController.navigate("detail_boutique") },
                    onClickQrCode = { navController.navigate("scanner") }

                )
            }
            composable("creation_boutique") {
                FormCreationBoutiqueView() {
                    navController.navigate(
                        "vue_boutiques"
                    )
                }
            }
            composable("detail_boutique"){
                DetailBoutiquesView(
                    onClickQrCode = { navController.navigate("scanner") },
                    onClick = {
                        navController.navigate(
                            "vue_boutiques"
                        )
                    },
                    onClickAjoutProduit = { navController.navigate("ajout_produit")},
                    onClickModifBoutique = { navController.navigate("modif_boutique") }
                )
            }
            composable("scanner"){
                ScanneurQrCodeView()
            }
            composable("ajout_produit"){
                FormAjoutProduitView(
                    onClick = {
                        navController.navigate(
                            "detail_boutique"
                        )
                    }
                )
            }
            composable("modif_boutique"){
                FormModificationBoutiqueView()
            }
            //Faudra changer la route
            composable("vue_panier") { MonPanier() {navController.navigate("detail_produit")} }
            composable("detail_produit"){
                DetailProduitView(onClickAjoutPanier = {navController.navigate("vue_panier")})
            }
            composable("vue_favoris") { MesFavoris() }
            composable("vue_profil") { MonProfil() }
        }
    }
}