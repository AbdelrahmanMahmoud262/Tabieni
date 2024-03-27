package com.tabieni.data_repository.repository

import com.tabieni.data_repository.source.SurahDataSource
import com.tabieni.domain.entity.Surah
import com.tabieni.domain.repository.SurahRepository
import javax.inject.Inject

class SurahRepositoryImpl @Inject constructor(
    private val surahDataSource: SurahDataSource
) :SurahRepository{

    override suspend fun getSurah(id: Int): Surah = surahDataSource.getSurah(id)
}