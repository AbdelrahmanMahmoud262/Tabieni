package com.tabieni.data_local.db.sorah

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sorah")
data class SorahEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "ayah_count") val ayahCount: Int,
    @ColumnInfo(name = "page") val page: Int,
)