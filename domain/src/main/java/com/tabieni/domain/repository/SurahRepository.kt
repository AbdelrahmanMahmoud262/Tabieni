package com.tabieni.domain.repository

import com.tabieni.domain.entity.Surah

interface SurahRepository {

    suspend fun getSurah(id:Int):Surah
}