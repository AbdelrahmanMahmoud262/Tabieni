package com.tabieni.data_local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tabieni.data_local.db.connection.ConnectionEntity
import com.tabieni.data_local.db.connection.ConnectionDao
import com.tabieni.data_local.db.memorize.MemorizeEntity
import com.tabieni.data_local.db.memorize.MemorizeDao
import com.tabieni.data_local.db.revision.RevisionEntity
import com.tabieni.data_local.db.sorah.SorahEntity

@Database(entities = [MemorizeEntity::class, ConnectionEntity::class, RevisionEntity::class,SorahEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun memorizeDao(): MemorizeDao
    abstract fun connectionDao(): ConnectionDao
}