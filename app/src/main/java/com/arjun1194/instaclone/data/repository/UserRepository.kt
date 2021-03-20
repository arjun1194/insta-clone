package com.arjun1194.instaclone.data.repository

import com.arjun1194.instaclone.api.UserService
import com.arjun1194.instaclone.data.database.UserDao
import com.arjun1194.instaclone.data.model.DataResponse
import com.arjun1194.instaclone.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao,
) {

    suspend fun getUsers(): Flow<DataResponse<List<User>>> {
        return flow {
            try {
                val networkResponse = userService.getUsers()
                userDao.deleteAll()
                userDao.insert(networkResponse.data)
            } catch (e: Exception) {
                emit(DataResponse.Error(Throwable(e.message,e.cause)))
            } finally {
                val users = userDao.getUsers();
                emit(DataResponse.Success(users))
            }

        }
    }
}