package com.picpay.desafio.android.ui.viewmodel

import com.picpay.desafio.android.models.User

data class UserViewState(
    val users: List<User>? = null,
    val error: String? = null,
    val isLoading: Boolean = true
) {

    fun postSuccess(newUsers: List<User>) = copy(
        users = newUsers,
        isLoading = false
    )

    fun postError(error: String?) = copy(
        error = error,
        isLoading = false
    )
}