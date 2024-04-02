package com.tabieni.domain.usecase

import com.tabieni.domain.entity.Connection
import com.tabieni.domain.entity.ConnectionWithSurah
import com.tabieni.domain.entity.RevisionWithSurah
import com.tabieni.domain.repository.ConnectionRepository
import com.tabieni.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetConnectionUseCase @Inject constructor(
    private val connectionRepository: ConnectionRepository,
    private val surahRepository: SurahRepository
){

    operator fun invoke():Flow<List<ConnectionWithSurah>> = connectionRepository.getConnection()
        .map {connectionList->
            connectionList.map {
                if (it.fromSorah != 0 || it.toSorah != 0) {
                    val fromSurah = surahRepository.getSurah(it.fromSorah)
                    val toSurah = surahRepository.getSurah(it.toSorah)
                    ConnectionWithSurah(
                        id = it.id,
                        part = it.part,
                        fromSurah = fromSurah,
                        toSurah = toSurah,
                        fromAyah = it.fromAyah,
                        toAyah = it.toAyah,
                        done = it.done
                    )
                }else{
                    ConnectionWithSurah(
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