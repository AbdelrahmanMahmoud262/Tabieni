package com.tabieni.data_repository.injection

import com.tabieni.data_repository.repository.MemorizeRepositoryImpl
import com.tabieni.domain.repository.MemorizeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMemorizeRepository(memorizeRepositoryImpl: MemorizeRepositoryImpl):MemorizeRepository
}