package com.tabieni.domain.usecase

import android.util.Log
import com.tabieni.domain.entity.Memorize
import com.tabieni.domain.entity.MemorizeWithSurah
import com.tabieni.domain.entity.Result
import com.tabieni.domain.repository.MemorizeRepository
import com.tabieni.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastMemorizedUseCase @Inject constructor(
    private val memorizeRepository: MemorizeRepository,
    private val surahRepository: SurahRepository,
) {

    suspend operator fun invoke(): Response {
        return try {
            val lastMemorized = memorizeRepository.getLastMemorized()
            val fromSurah = surahRepository.getSurah(lastMemorized.fromSurah)
            val toSurah = surahRepository.getSurah(lastMemorized.toSurah)
            Response(
                Result.Success(
                    MemorizeWithSurah(
                        lastMemorized.id,
                        lastMemorized.part,
                        fromSurah,
                        toSurah,
                        lastMemorized.fromAyah,
                        lastMemorized.toAyah,
                        lastMemorized.done
                    )
                )
            )
        }catch (e: Exception){
            Log.e("GetLastMemorizedUseCase", e.message, e)
            Response(Result.Error(UseCaseException.createFromThrowable(e)))
        }
    }

    data class Response(val result: Result<MemorizeWithSurah>) : UseCase.Response
}