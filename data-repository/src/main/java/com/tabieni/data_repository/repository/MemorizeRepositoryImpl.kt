package com.tabieni.data_repository.repository

import android.util.Log
import com.tabieni.data_repository.source.MemorizeDataSource
import com.tabieni.domain.entity.Memorize
import com.tabieni.domain.repository.MemorizeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemorizeRepositoryImpl @Inject constructor(
    private val memorizeDataSource: MemorizeDataSource,
) : MemorizeRepository {

    override suspend  fun getMemorize(): Memorize {

        Log.e("repoImpl", "here")
        return memorizeDataSource.getMemorize()
    }

    override suspend fun getLastMemorized(): Memorize =
        memorizeDataSource.getLastMemorized()
}