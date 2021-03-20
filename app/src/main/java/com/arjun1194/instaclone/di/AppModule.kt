package com.arjun1194.instaclone.di

import android.content.Context
import com.arjun1194.instaclone.api.UserService
import com.arjun1194.instaclone.data.database.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun provideNewsService(): UserService {
        return UserService.create()
    }

    fun provideDatabase(@ApplicationContext context: Context): UserDatabase {
        return UserDatabase.getInstance(context)
    }



}