package com.arjun1194.instaclone.di

import com.arjun1194.instaclone.api.UserService
import com.arjun1194.instaclone.data.database.UserDao
import com.arjun1194.instaclone.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideNewsRepository(
        userService: UserService,
        userDao: UserDao): UserRepository {
        return UserRepository(userService, userDao)
    }

}