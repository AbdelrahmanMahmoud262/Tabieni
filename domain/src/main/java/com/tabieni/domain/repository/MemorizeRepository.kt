package com.tabieni.domain.repository

import com.tabieni.domain.entity.Memorize
import kotlinx.coroutines.flow.Flow

interface MemorizeRepository {

    fun  getMemorize():Flow<List<Memorize>>

    suspend fun getLastMemorized():Memorize
}