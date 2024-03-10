package com.tabieni.data_local.injection

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tabieni.data_local.db.AppDatabase
import com.tabieni.data_local.db.memorize.MemorizeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context):AppDatabase =
        Room.databaseBuilder(context,AppDatabase::class.java,"tabieni")
            .createFromAsset("tabieni.db")
            .build()

    @Provides
    fun provideMemorizeDao(appDatabase: AppDatabase):MemorizeDao = appDatabase.memorizeDao()
}