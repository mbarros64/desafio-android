package com.picpay.desafio.android.database.dao

import com.picpay.desafio.android.data.database.dao.UserDao
import com.picpay.desafio.android.data.database.entities.UserEntity

class UserDaoTestMock : UserDao {

    private val list = mutableListOf<UserEntity>()

    override suspend fun getAll() = list

    override suspend fun insertAll(users: List<UserEntity>) {
        list.addAll(users)
    }

    override suspend fun deleteAll() {
        list.clear()
    }
}