package com.projs.roomdb_mvvm.model

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

interface ProductDao {

    @Insert
    fun addProd(p: Product): Long

    @Query("Select * from product")
    fun getProd(): LiveData<List<Product>>
}
