package com.panierdantan.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panierdantan.repositories.RealmShopRepository
import com.panierdantan.models.shops.Boutique
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DataViewModel : ViewModel() {


    val shops = MutableStateFlow<List<Boutique>>(listOf())

    private val shopRepository : RealmShopRepository  = RealmShopRepository()

     fun addShop(boutique: Boutique) {
        viewModelScope.launch {
            shopRepository.addShop(boutique)
        }
    }

    fun getShops() {
        viewModelScope.launch {
            shops.value = shopRepository.getShopList()
        }
    }

    fun close() {
        shopRepository.close()
    }
}