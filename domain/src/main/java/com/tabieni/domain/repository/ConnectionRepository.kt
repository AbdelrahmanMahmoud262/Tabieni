package com.tabieni.domain.repository

import com.tabieni.domain.entity.Connection
import kotlinx.coroutines.flow.Flow

interface ConnectionRepository {

    fun getConnection(): Flow<List<Connection>>

    fun getLastConnection(): Flow<Connection>
}