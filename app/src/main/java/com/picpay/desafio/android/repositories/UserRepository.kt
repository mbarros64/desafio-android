package com.picpay.desafio.android.repositories

import com.picpay.desafio.android.data.api.responses.toEntity
import com.picpay.desafio.android.data.api.services.UserService
import com.picpay.desafio.android.data.database.dao.UserDao
import com.picpay.desafio.android.data.database.entities.toDomain
import com.picpay.desafio.android.network.ResultWrapper
import com.picpay.desafio.android.network.safeDataRequest
import kotlinx.coroutines.flow.flow

class UserRepository(
    private val userService: UserService,
    private val userDao: UserDao
) {

     fun getUsers() = flow {
        emit(userDao.getAll().toDomain())

        when (val result = safeDataRequest { userService.getUsers() }) {
            is ResultWrapper.Success -> {
                val userEntity = result.content.toEntity()
                userDao.deleteAll()
                userDao.insertAll(userEntity)
                emit(userEntity.toDomain())
            }
            is ResultWrapper.Error -> throw result.throwable
        }
    }
}