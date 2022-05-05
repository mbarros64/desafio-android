package com.picpay.desafio.android.user.network

import com.picpay.desafio.android.user.domain.UserDomain
import junit.framework.Assert.assertEquals
import org.junit.Test

class UserResponseKtTest {

    @Test
    fun `Should map user response to user domain correctly`() {
        val actual = listOf(
            UserResponse(img = "img", name = "name", id = 1, username = "username")
        )

        val expected = listOf(
            UserDomain(imageUrl = "img", name = "name", id = 1, userName = "username")
        )

        assertEquals(expected, actual.toDomain())
    }
}