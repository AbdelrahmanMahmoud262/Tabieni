package com.tabieni.domain.repository

import com.tabieni.domain.entity.Memorize
import kotlinx.coroutines.flow.Flow

interface MemorizeRepository {

     suspend fun  getMemorize():Memorize

    suspend fun getLastMemorized():Memorize
}