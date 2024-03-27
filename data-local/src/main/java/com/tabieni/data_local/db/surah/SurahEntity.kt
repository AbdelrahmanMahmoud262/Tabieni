package com.tabieni.data_local.db.surah

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surah")
data class SurahEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "arabic_name") val arabicName: String,
    @ColumnInfo(name = "english_name") val englishName: String,
    @ColumnInfo(name = "arabic_type") val arabicType: String,
    @ColumnInfo(name = "english_type") val englishType: String,
    @ColumnInfo(name = "ayah_count") val ayahCount: Int,
    @ColumnInfo(name = "meaning_english") val meaningEnglish: String,
    @ColumnInfo(name = "page") val page: Int,
)