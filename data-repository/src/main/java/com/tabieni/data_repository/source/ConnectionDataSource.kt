package com.tabieni.data_repository.source

import com.tabieni.domain.entity.Connection
import kotlinx.coroutines.flow.Flow

interface ConnectionDataSource {


    fun getConnection(): Flow<List<Connection>>

    fun getLastConnection():Flow<Connection>


}