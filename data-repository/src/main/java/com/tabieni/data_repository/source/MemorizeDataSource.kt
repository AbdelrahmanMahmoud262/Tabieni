package com.tabieni.data_repository.source

import com.tabieni.domain.entity.Memorize
import kotlinx.coroutines.flow.Flow

interface MemorizeDataSource {

     fun getMemorize():Flow<List<Memorize>>

    suspend fun getLastMemorized():Memorize
}