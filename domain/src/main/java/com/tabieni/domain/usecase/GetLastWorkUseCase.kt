package com.tabieni.domain.usecase

import android.util.Log
import com.tabieni.domain.entity.Collection
import com.tabieni.domain.entity.Memorize
import com.tabieni.domain.repository.ConnectionRepository
import com.tabieni.domain.repository.MemorizeRepository
import com.tabieni.domain.repository.RevisionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLastWorkUseCase @Inject constructor(
    configuration: Configuration,
    private val memorizeRepository: MemorizeRepository,
    private val connectionRepository: ConnectionRepository,
    private val revisionRepository: RevisionRepository,
) :UseCase<GetLastWorkUseCase.Request, GetLastWorkUseCase.Response>(configuration){

//    suspend fun process(request: Request): Response {
//        Log.e("here", "here)")
//        return memorizeRepository.getMemorize().let {
//            Log.e("mapping", it.toString())
//            Response(it)
//        }
//    }

    override fun process(request: Request): Flow<Response> {
//        return memorizeRepository.getLastMemorized()
//            .map {
//                Log.e("mapping",it.toString())
//                Response(it)
//            }
        return flow {  }
    }

    data object Request : UseCase.Request
    data class Response(val collection: Memorize) : UseCase.Response
}