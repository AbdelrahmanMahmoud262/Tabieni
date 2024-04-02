package com.tabieni.domain.usecase

import com.tabieni.domain.entity.RevisionWithSurah
import com.tabieni.domain.repository.RevisionRepository
import com.tabieni.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRevisionUseCase @Inject constructor(
    private val revisionRepository: RevisionRepository,
    private val surahRepository: SurahRepository
) {

    operator fun invoke() : Flow<List<RevisionWithSurah>> = revisionRepository.getRevision()
        .map { revisionList->
            revisionList.map {
                if (it.fromSurah != 0 || it.toSorah != 0) {
                    val fromSurah = surahRepository.getSurah(it.fromSurah)
                    val toSurah = surahRepository.getSurah(it.toSorah)
                    RevisionWithSurah(
                        id = it.id,
                        part = it.part,
                        fromSurah = fromSurah,
                        toSurah = toSurah,
                        fromAyah = it.fromAyah,
                        toAyah = it.toAyah,
                        done = it.done
                    )
                }else{
                    RevisionWithSurah(
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