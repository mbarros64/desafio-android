package com.picpay.desafio.android.database.entity

import com.picpay.desafio.android.data.database.entities.UserEntity
import com.picpay.desafio.android.data.database.entities.toDomain
import com.picpay.desafio.android.models.User
import org.junit.Test
import kotlin.test.assertEquals

class UserEntityTest {
    @Test
    fun `Should map user response to user domain correctly`() {
        val actual = listOf(
            UserEntity(imageUrl = "img", name = "name", id = 1, userName = "username")
        )

        val expected = listOf(
            User(imageUrl = "img", name = "name", id = 1, userName = "username")
        )

        assertEquals(expected, actual.toDomain())
    }
}