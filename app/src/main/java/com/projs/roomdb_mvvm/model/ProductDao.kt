package com.projs.roomdb_mvvm.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    suspend fun addProd(p: Product): Long

    @Query("Select * from product")
    fun getProd(): LiveData<List<Product>>
}
