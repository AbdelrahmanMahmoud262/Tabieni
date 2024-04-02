package com.tabieni.domain.usecase

import com.tabieni.domain.entity.Memorize
import com.tabieni.domain.entity.MemorizeWithSurah
import com.tabieni.domain.entity.RevisionWithSurah
import com.tabieni.domain.repository.MemorizeRepository
import com.tabieni.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMemorizeUseCase @Inject constructor(
    private val memorizeRepository: MemorizeRepository,
    private val surahRepository: SurahRepository,
) {

    operator fun invoke(): Flow<List<MemorizeWithSurah>> =
        memorizeRepository.getMemorize()
            .map { memorizeList ->
                memorizeList.map {
                    if (it.fromSurah != 0 || it.toSurah != 0) {
                        val fromSurah = surahRepository.getSurah(it.fromSurah)
                        val toSurah = surahRepository.getSurah(it.toSurah)
                        MemorizeWithSurah(
                            id = it.id,
                            part = it.part,
                            fromSurah = fromSurah,
                            toSurah = toSurah,
                            fromAyah = it.fromAyah,
                            toAyah = it.toAyah,
                            done = it.done
                        )
                    }else{
                        MemorizeWithSurah(
                            id = it.id,
                            part = it.part,
                            fromAyah = it.fromAyah,
                            toAyah = it.toAyah,
                            done = it.done
                        )
                    }
                }
            }
}