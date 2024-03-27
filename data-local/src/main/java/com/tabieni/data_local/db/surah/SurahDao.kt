package com.tabieni.data_local.db.surah

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SurahDao {

    @Query("SELECT * FROM surah where id == :id")
    suspend fun getSurah(id:Int):SurahEntity

}