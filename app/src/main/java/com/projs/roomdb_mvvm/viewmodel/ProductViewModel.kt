package com.projs.roomdb_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.projs.roomdb_mvvm.model.local.IRepository
import com.projs.roomdb_mvvm.model.Product

class ProductViewModel(val repo: IRepository): ViewModel() {

    val products: LiveData<List<Product>> =repo.products

    val newprodId= MutableLiveData<Long>()

    private var name: String=""
    private var category: String=""
    private var price: Float=0f

    fun onInputDataChanged(n: String,c: String,p: Float){
        name=n
        category=c
        price=p
        addProduct()
    }

    private fun addProduct()
    {
        var prod= Product(productName = name, category = category, price = price)

        val prodId=repo.addProduct(prod)
        newprodId.postValue(prodId)
    }
}
class ProductVMFactory(val repo: IRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repo) as T
    }
}



