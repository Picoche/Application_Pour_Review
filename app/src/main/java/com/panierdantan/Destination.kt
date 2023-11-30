package com.panierdantan

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.panierdantan.custom_icons.FavorisIcon
import com.panierdantan.custom_icons.MapIcon
import com.panierdantan.custom_icons.ShopIcon
import com.panierdantan.custom_icons.ShoppingBag
import com.panierdantan.custom_icons.UserIcon


sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object VueBoutiques : Destination("vue_boutiques", "VueBoutiques", Icons.ShopIcon)
    object GestionBoutiques : Destination("gestion_boutiques", "GestionBoutiques", Icons.Default.Search)
    object VueBoutique : Destination("vue_boutique", "VueBoutique", Icons.Default.Home)
    object VuePanier : Destination("vue_panier", "VuePanier", Icons.ShoppingBag)
    object VueFavoris : Destination("vue_favoris", "VueFavoris", Icons.FavorisIcon)
    object VueProfil : Destination("vue_profil", "VueProfil", Icons.UserIcon)
    object FormCreationBoutique : Destination("form_creation_boutique", "FormCreationBoutique", Icons.Default.Search)
    object Profil : Destination("profil", "Profil", Icons.Default.Home)
    object Carte : Destination("carte", "Carte", Icons.MapIcon)
    object CreationBoutique : Destination("creation_boutique", "CreationBoutique", Icons.Default.Search)
    object vueDetailBoutique : Destination("detail_boutique", "VueDetailBoutiques", Icons.Default.Search)
    object vueScanneurQrCode : Destination("scanner", "vueScanneurQrCode", Icons.Default.Search)
    object ModificationBoutique : Destination("modif_boutique", "ModificationBoutique", Icons.Default.Search)
    object AjoutProduit : Destination("ajout_produit", "AjoutProduit", Icons.Default.Search)

    object DetailProduit : Destination("detail_produit", "DetailProduit", Icons.Default.Search)

}