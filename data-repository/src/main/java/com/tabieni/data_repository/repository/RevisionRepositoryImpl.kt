package com.tabieni.data_repository.repository

import com.tabieni.data_repository.source.RevisionDataSource
import com.tabieni.domain.entity.Revision
import com.tabieni.domain.repository.RevisionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RevisionRepositoryImpl @Inject constructor(
    private val dataSource: RevisionDataSource,
) : RevisionRepository {
    override fun getRevision(): Revision =
        dataSource.getRevision()

    override fun getLastRevised(): Flow<Revision> =
    dataSource.getLastRevised()
}