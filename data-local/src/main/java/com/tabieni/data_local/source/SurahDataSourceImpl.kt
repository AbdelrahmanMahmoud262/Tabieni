package com.tabieni.data_local.source

import android.util.Log
import com.tabieni.data_local.db.surah.SurahDao
import com.tabieni.data_repository.source.SurahDataSource
import com.tabieni.domain.entity.Surah
import javax.inject.Inject

class SurahDataSourceImpl @Inject constructor(
    private val surahDao: SurahDao
) :SurahDataSource{
    override suspend fun getSurah(id: Int): Surah = surahDao.getSurah(id)
        .let {
            Log.e("datasource", it.toString())
            Surah(
                id = it.id,
                arabicName = it.arabicName,
                englishName = it.englishName,
                arabicType = it.arabicType,
                englishType = it.englishType,
                ayahCount = it.ayahCount,
                meaningEnglish = it.meaningEnglish,
                page = it.page
            )
        }
}