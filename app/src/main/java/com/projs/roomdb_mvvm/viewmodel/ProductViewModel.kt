package com.projs.roomdb_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.projs.roomdb_mvvm.model.local.IRepository
import com.projs.roomdb_mvvm.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repo: IRepository): ViewModel() {

    val products: LiveData<List<Product>> = repo.products

    val newprodId = MutableLiveData<Long>()


    fun onInputDataChanged(name: String, category: String, price: Float) {
        val prod = Product(productName = name, category = category, price = price)

        viewModelScope.launch(Dispatchers.IO) {
            val id = repo.addProduct(prod)
            newprodId.postValue(id)
        }

    }
}



