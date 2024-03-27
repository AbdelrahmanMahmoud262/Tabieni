package com.tabieni.data_repository.source

import com.tabieni.domain.entity.Surah

interface SurahDataSource {

    suspend fun getSurah(id:Int):Surah
}