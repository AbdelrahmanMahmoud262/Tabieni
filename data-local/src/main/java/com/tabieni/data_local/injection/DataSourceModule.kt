package com.tabieni.data_local.injection

import com.tabieni.data_local.source.MemorizeDataSourceImpl
import com.tabieni.data_repository.source.MemorizeDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindMemorizeDataSource(memorizeDataSourceImpl: MemorizeDataSourceImpl):MemorizeDataSource
}