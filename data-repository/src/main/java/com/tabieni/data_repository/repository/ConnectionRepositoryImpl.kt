package com.tabieni.data_repository.repository

import com.tabieni.data_repository.source.ConnectionDataSource
import com.tabieni.domain.entity.Connection
import com.tabieni.domain.repository.ConnectionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConnectionRepositoryImpl @Inject constructor(
    private val dataSource: ConnectionDataSource,
) : ConnectionRepository {

    override fun getConnection(): Flow<List<Connection>> =
        dataSource.getConnection()

    override fun getLastConnection(): Flow<Connection> =
        dataSource.getLastConnection()
}