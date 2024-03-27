package com.tabieni.domain.repository

import com.tabieni.domain.entity.Revision
import kotlinx.coroutines.flow.Flow

interface RevisionRepository {

    fun getRevision(): Revision

    fun getLastRevised(): Flow<Revision>
}