package com.projs.roomdb_mvvm.module

import android.content.Context
import androidx.annotation.UiContext
import androidx.room.Room
import com.projs.roomdb_mvvm.model.ProductDB
import com.projs.roomdb_mvvm.model.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDB(
        @ApplicationContext context: Context
    ): ProductDB{

        return Room.databaseBuilder(
            context,
            ProductDB::class.java,
            "ShopDB"
        ).build()


    }
    @Provides
    fun provideDao(db: ProductDB): ProductDao{
        return db.productDao()
    }
}