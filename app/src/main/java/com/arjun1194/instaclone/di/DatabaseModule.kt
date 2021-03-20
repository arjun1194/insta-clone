package com.arjun1194.instaclone.di

import android.content.Context
import com.arjun1194.instaclone.data.database.UserDao
import com.arjun1194.instaclone.data.database.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesNewsDatabase(
        @ApplicationContext context: Context
    ): UserDatabase {
        return UserDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun providesNewsDao(
        userDatabase: UserDatabase
    ): UserDao {
        return userDatabase.userDao()
    }
}