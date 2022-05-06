package com.picpay.desafio.android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.data.database.dao.UserDao
import com.picpay.desafio.android.data.database.entities.UserEntity


@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}