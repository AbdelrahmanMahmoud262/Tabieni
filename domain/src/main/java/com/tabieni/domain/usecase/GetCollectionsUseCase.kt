package com.tabieni.domain.usecase

import com.tabieni.domain.entity.Collection
import com.tabieni.domain.entity.Connection
import com.tabieni.domain.entity.ConnectionWithSurah
import com.tabieni.domain.entity.Memorize
import com.tabieni.domain.entity.MemorizeWithSurah
import com.tabieni.domain.entity.Revision
import com.tabieni.domain.entity.RevisionWithSurah
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetCollectionsUseCase @Inject constructor(
    private val getMemorizeUseCase: GetMemorizeUseCase,
    private val getConnectionUseCase: GetConnectionUseCase,
    private val getRevisionUseCase: GetRevisionUseCase,
) {
    operator fun invoke() =
        getMemorizeUseCase.invoke()
            .zip(getConnectionUseCase.invoke()) { memorizeList: List<MemorizeWithSurah>, connectionList: List<ConnectionWithSurah> ->
                memorizeList.map { memorize ->
                    val connection =
                        connectionList.firstOrNull { it.id == memorize.id }// Default Connection() if list is shorter
                    Collection(memorize, connection, null) // Assuming Revision() is a default value
                }
            }
            .combine(getRevisionUseCase.invoke()) { combinedList: List<Collection>, revisionList: List<RevisionWithSurah> ->
                combinedList.map { collection ->
                    val revision = revisionList.firstOrNull { it.id == collection.memorize?.id }
                    collection.copy(revision = revision)
                }
            }
}