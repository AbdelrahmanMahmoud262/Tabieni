package com.tabieni.data_local.db.revision

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RevisionDao {

    @Query("SELECT * FROM revision where done == 0 limit 1")
    fun getRevision() : RevisionEntity

    @Query("SELECT * FROM memorize WHERE done == 1 limit 1")
    fun getLastRevised(): Flow<RevisionEntity>

}