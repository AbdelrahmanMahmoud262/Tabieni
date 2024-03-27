package com.tabieni.domain.repository

import com.tabieni.domain.entity.Connection
import kotlinx.coroutines.flow.Flow

interface ConnectionRepository {

    fun getConnection(): Connection

    fun getLastConnection(): Flow<Connection>
}