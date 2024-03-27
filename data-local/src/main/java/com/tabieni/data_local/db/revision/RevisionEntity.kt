package com.tabieni.data_local.db.revision

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "revision"
)
data class RevisionEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "part") val part: Int,
    @ColumnInfo(name = "from_sorah") val fromSorah: Int,
    @ColumnInfo(name = "to_sorah") val toSorah: Int,
    @ColumnInfo(name = "from_ayah") val fromAyah: Int,
    @ColumnInfo(name = "to_ayah") val toAyah: Int,
    @ColumnInfo(name = "done") val done: Boolean?
)
