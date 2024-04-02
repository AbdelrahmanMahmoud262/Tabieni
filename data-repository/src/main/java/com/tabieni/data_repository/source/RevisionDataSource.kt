package com.tabieni.data_repository.source

import com.tabieni.domain.entity.Revision
import kotlinx.coroutines.flow.Flow

interface RevisionDataSource {


    fun getRevision(): Flow<List<Revision>>

    fun getLastRevised(): Flow<Revision>
}