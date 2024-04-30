package com.tabieni.data_local.injection

import com.tabieni.data_local.source.ConnectionDataSourceImpl
import com.tabieni.data_local.source.MemorizeDataSourceImpl
import com.tabieni.data_local.source.PlanDataSourceImpl
import com.tabieni.data_local.source.RevisionDataSourceImpl
import com.tabieni.data_local.source.SurahDataSourceImpl
import com.tabieni.data_repository.source.ConnectionDataSource
import com.tabieni.data_repository.source.MemorizeDataSource
import com.tabieni.data_repository.source.PlanDataSource
import com.tabieni.data_repository.source.RevisionDataSource
import com.tabieni.data_repository.source.SurahDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindMemorizeDataSource(memorizeDataSourceImpl: MemorizeDataSourceImpl): MemorizeDataSource

    @Binds
    abstract fun bindRevisionDataSource(revisionDataSourceImpl: RevisionDataSourceImpl): RevisionDataSource

    @Binds
    abstract fun bindConnectionDataSource(connectionDataSourceImpl: ConnectionDataSourceImpl): ConnectionDataSource

    @Binds
    abstract fun bindSurahDataSource(surahDataSourceImpl: SurahDataSourceImpl): SurahDataSource

    @Binds
    abstract fun bindPlanDataSource(planDataSourceImpl: PlanDataSourceImpl):PlanDataSource
}