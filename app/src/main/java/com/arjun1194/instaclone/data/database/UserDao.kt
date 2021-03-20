package com.arjun1194.instaclone.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arjun1194.instaclone.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: List<User>): LongArray

    @Query("DELETE FROM users")
    suspend fun deleteAll()

}