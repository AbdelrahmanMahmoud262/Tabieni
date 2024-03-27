package com.tabieni.data_repository.source

import com.tabieni.domain.entity.Memorize
import kotlinx.coroutines.flow.Flow

interface MemorizeDataSource {

    suspend fun getMemorize():Memorize

    suspend fun getLastMemorized():Memorize
}