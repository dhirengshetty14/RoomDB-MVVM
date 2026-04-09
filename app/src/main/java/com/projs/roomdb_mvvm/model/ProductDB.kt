package com.projs.roomdb_mvvm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDB : RoomDatabase() {

    abstract fun productDao(): ProductDao
    companion object {
        private lateinit var prodDB: ProductDB

        fun getInstance(context: Context): ProductDB {
            if (!::prodDB.isInitialized) {
                prodDB = Room.databaseBuilder(context, ProductDB::class.java, "ShopDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return prodDB
        }
    }
}