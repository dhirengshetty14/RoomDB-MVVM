package com.projs.roomdb_mvvm.model.local

import androidx.lifecycle.LiveData
import com.projs.roomdb_mvvm.model.Product

interface IRepository {
    val products: LiveData<List<Product>>

    fun addProduct(p: Product): Long
}