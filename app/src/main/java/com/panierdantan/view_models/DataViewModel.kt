package com.panierdantan.view_models

import androidx.lifecycle.ViewModel
import com.panierdantan.repositories.RealmShopRepository
import com.panierdantan.models.shops.Boutique
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {


    private val _shops: MutableCollection<Boutique> = mutableListOf(Boutique())
    val shops: Collection<Boutique>
        get() = _shops

    private val shopRepository : RealmShopRepository  = RealmShopRepository()

     fun addShop(boutique: Boutique) {
        CoroutineScope(Dispatchers.IO).launch {
            shopRepository.addShop(boutique)
        }
    }
    fun getShops() {
        CoroutineScope(Dispatchers.IO).launch {
            _shops.addAll(shopRepository.getShopList())
        }
    }
}