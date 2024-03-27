package com.tabieni.data_repository.injection

import com.tabieni.data_repository.repository.ConnectionRepositoryImpl
import com.tabieni.data_repository.repository.MemorizeRepositoryImpl
import com.tabieni.data_repository.repository.RevisionRepositoryImpl
import com.tabieni.data_repository.repository.SurahRepositoryImpl
import com.tabieni.domain.repository.ConnectionRepository
import com.tabieni.domain.repository.MemorizeRepository
import com.tabieni.domain.repository.RevisionRepository
import com.tabieni.domain.repository.SurahRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMemorizeRepository(memorizeRepositoryImpl: MemorizeRepositoryImpl):MemorizeRepository

    @Binds
    abstract fun bindRevisionRepository(revisionRepositoryImpl: RevisionRepositoryImpl): RevisionRepository

    @Binds
    abstract fun bindConnectionRepository(connectionRepositoryImpl: ConnectionRepositoryImpl): ConnectionRepository

    @Binds
    abstract fun bindSurahRepository(surahRepositoryImpl: SurahRepositoryImpl): SurahRepository
}