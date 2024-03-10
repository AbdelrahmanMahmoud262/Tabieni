package com.tabieni.data_local.db.connection

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ConnectionDao {

    @Query("SELECT * FROM connection")
    fun getConnection():Flow<List<ConnectionEntity>>
}