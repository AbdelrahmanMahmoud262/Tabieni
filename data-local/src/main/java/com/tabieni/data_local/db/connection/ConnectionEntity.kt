package com.tabieni.data_local.db.connection

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.tabieni.data_local.db.sorah.SorahEntity

@Entity(
    tableName = "connection",
    foreignKeys = [ForeignKey(
        entity = SorahEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("from_sorah"),
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = SorahEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("to_sorah"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class ConnectionEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "part") val part: Int,
    @ColumnInfo(name = "from_sorah") val fromSorah: Int,
    @ColumnInfo(name = "to_sorah") val toSorah: Int,
    @ColumnInfo(name = "from_ayah") val fromAyah: Int,
    @ColumnInfo(name = "to_ayah") val toAyah: Int,
    @ColumnInfo(name = "done") val done: Boolean?
)