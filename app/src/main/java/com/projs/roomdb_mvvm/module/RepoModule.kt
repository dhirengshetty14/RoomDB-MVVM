package com.projs.roomdb_mvvm.module

import com.projs.roomdb_mvvm.model.local.IRepository
import com.projs.roomdb_mvvm.model.local.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule{
    @Binds
    @Singleton
    abstract fun bindRepo(
        repo: Repository
    ): IRepository
}