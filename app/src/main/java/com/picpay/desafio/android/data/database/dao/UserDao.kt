package com.picpay.desafio.android.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.picpay.desafio.android.data.database.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>

    @Insert
    suspend fun insertAll(users: List<UserEntity>)

    @Query("DELETE from user")
    suspend fun deleteAll()
}