package com.tabieni.data_local.db.memorize

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MemorizeDao {

    @Query("SELECT * FROM memorize")
    fun getMemorize(): Flow<List<MemorizeEntity>>

    @Query("SELECT * FROM memorize where done = 1 limit (SELECT max(id) FROM memorize where done = 1)")
    suspend fun getLastMemorized():MemorizeEntity
}