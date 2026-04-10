package com.projs.roomdb_mvvm.model.local

import androidx.lifecycle.LiveData
import com.projs.roomdb_mvvm.model.Product
import com.projs.roomdb_mvvm.model.ProductDB
import javax.inject.Inject

class Repository @Inject constructor(
    private val prodDB: ProductDB
) : IRepository {

    override val products: LiveData<List<Product>> =
        prodDB.productDao().getProd()

    override suspend fun addProduct(p: Product): Long {
        return prodDB.productDao().addProd(p)
    }
}