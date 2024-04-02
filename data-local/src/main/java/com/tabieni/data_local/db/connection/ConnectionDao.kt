package com.tabieni.data_local.db.connection

import androidx.room.Dao
import androidx.room.Query
import com.tabieni.data_local.db.revision.RevisionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConnectionDao {

    @Query("SELECT * FROM connection")
    fun getConnection() : Flow<List<ConnectionEntity>>

    @Query("SELECT * FROM connection WHERE done == 1  limit 1")
    fun getLastConnection(): Flow<ConnectionEntity>
}