package com.tabieni.data_local.source

import android.util.Log
import com.tabieni.data_local.db.connection.ConnectionDao
import com.tabieni.data_repository.source.ConnectionDataSource
import com.tabieni.domain.entity.Connection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ConnectionDataSourceImpl @Inject constructor(
    private val connectionDao: ConnectionDao,
) : ConnectionDataSource {

    override fun getConnection(): Connection =
        connectionDao.getConnection().let {
            Connection(it.id, it.part, it.fromSorah, it.toSorah, it.fromAyah, it.toAyah, it.done)
        }

    override fun getLastConnection(): Flow<Connection> =
        connectionDao.getLastConnection().map {
            Log.e("connection",it.toString())
            Connection(it.id, it.part, it.fromSorah, it.toSorah, it.fromAyah, it.toAyah, it.done)
        }
}