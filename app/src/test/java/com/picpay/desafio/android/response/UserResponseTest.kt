package com.picpay.desafio.android.response

import com.picpay.desafio.android.data.api.responses.UserResponse
import com.picpay.desafio.android.data.api.responses.toDomain
import com.picpay.desafio.android.models.User
import junit.framework.TestCase.assertEquals
import org.junit.Test

class UserResponseTest {

    @Test
    fun `Should map user response to user domain correctly`() {
        val actual = listOf(
            UserResponse(img = "img", name = "name", id = 1, username = "username")
        )

        val expected = listOf(
            User(imageUrl = "img", name = "name", id = 1, userName = "username")
        )

        assertEquals(expected, actual.toDomain())
    }
}