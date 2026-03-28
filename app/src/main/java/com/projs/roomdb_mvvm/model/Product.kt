package com.projs.roomdb_mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(

    @ColumnInfo(name="pid")
    @PrimaryKey(autoGenerate = true)
    val pid: Long=0,

    @ColumnInfo(name="product_name")
    val productName: String,

    @ColumnInfo(name="category")
    val category: String,

    @ColumnInfo(name = "price")
    val price: Float
)

