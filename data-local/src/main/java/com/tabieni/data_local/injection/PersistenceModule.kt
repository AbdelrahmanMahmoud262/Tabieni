package com.tabieni.data_local.injection

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.tabieni.data_local.db.AppDatabase
import com.tabieni.data_local.db.connection.ConnectionDao
import com.tabieni.data_local.db.memorize.MemorizeDao
import com.tabieni.data_local.db.revision.RevisionDao
import com.tabieni.data_local.db.surah.SurahDao
import com.tabieni.data_local.source.PlanDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "tabieni_datasotre")

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase =
        Room.databaseBuilder(context,AppDatabase::class.java,"app.db")
            .createFromAsset("database/tabieni.db")
            .build()



    @Provides
    fun provideMemorizeDao(appDatabase: AppDatabase):MemorizeDao {
        return appDatabase.memorizeDao()
    }

    @Provides
    fun provideConnectionDao(appDatabase: AppDatabase):ConnectionDao = appDatabase.connectionDao()

    @Provides
    fun provideRevisionDao(appDatabase: AppDatabase):RevisionDao = appDatabase.revisionDao()

    @Provides
    fun provideSurahDao(appDatabase: AppDatabase):SurahDao = appDatabase.surahDao()

    @Provides
    fun providePlanDataSourceImpl(@ApplicationContext context: Context) =
        PlanDataSourceImpl(context.dataStore)
}