package com.tabieni.data_local.source

import com.tabieni.data_local.db.memorize.MemorizeDao
import com.tabieni.data_repository.source.MemorizeDataSource
import com.tabieni.domain.entity.Memorize
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemorizeDataSourceImpl @Inject constructor(
    private val memorizeDao: MemorizeDao
) :MemorizeDataSource{

    override fun getMemorize(): Flow<List<Memorize>> =
        memorizeDao.getMemorize()
            .map {
                it.map { memorizeEntity->
                    Memorize(memorizeEntity.id,memorizeEntity.part,memorizeEntity.fromSorah,memorizeEntity.toSorah,memorizeEntity.fromAyah,memorizeEntity.toAyah,
                        memorizeEntity.done != 0
                    )
                }
            }
}