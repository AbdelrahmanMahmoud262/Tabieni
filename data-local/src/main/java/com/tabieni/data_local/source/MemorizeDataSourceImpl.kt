package com.tabieni.data_local.source

import android.util.Log
import com.tabieni.data_local.db.memorize.MemorizeDao
import com.tabieni.data_repository.source.MemorizeDataSource
import com.tabieni.domain.entity.Memorize
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Scope

class MemorizeDataSourceImpl @Inject constructor(
    private val memorizeDao: MemorizeDao,
) : MemorizeDataSource {

    override suspend  fun getMemorize(): Memorize  = memorizeDao.getMemorize()
            .let { memorizeEntity ->
                Memorize(
                    memorizeEntity.id,
                    memorizeEntity.part,
                    memorizeEntity.fromSorah,
                    memorizeEntity.toSorah,
                    memorizeEntity.fromAyah,
                    memorizeEntity.toAyah,
                    memorizeEntity.done != 0
                )
            }
    override suspend fun getLastMemorized(): Memorize =
        memorizeDao.getLastMemorized()
            .let {
            Log.e("memorize", it.toString())
            Memorize(it.id, it.part, it.fromSorah, it.toSorah, it.fromAyah, it.toAyah, it.done != 0)
        }
}