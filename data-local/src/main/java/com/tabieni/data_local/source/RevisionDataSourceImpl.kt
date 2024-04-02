package com.tabieni.data_local.source

import com.tabieni.data_local.db.revision.RevisionDao
import com.tabieni.data_repository.source.RevisionDataSource
import com.tabieni.domain.entity.Revision
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RevisionDataSourceImpl @Inject constructor(
    private val revisionDao: RevisionDao,
) : RevisionDataSource {

    override fun getRevision(): Flow<List<Revision>> =
        revisionDao.getRevision().map { revisionList ->
            revisionList.map {
                Revision(it.id, it.part, it.fromSorah, it.toSorah, it.fromAyah, it.toAyah, it.done)
            }
        }

    override fun getLastRevised(): Flow<Revision> =
        revisionDao.getLastRevised().map {
            Revision(it.id, it.part, it.fromSorah, it.toSorah, it.fromAyah, it.toAyah, it.done)
        }
}