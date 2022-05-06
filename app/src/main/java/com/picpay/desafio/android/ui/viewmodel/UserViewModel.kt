package com.picpay.desafio.android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.utils.extensions.updateAsync
import com.picpay.desafio.android.repositories.UserRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository): ViewModel() {

    private val userViewState = MutableLiveData(UserViewState())
    val state: LiveData<UserViewState>
        get() = userViewState

    fun getUsers() {
        viewModelScope.launch {
            repository.getUsers()
                .catch { cause -> userViewState.updateAsync { postError(cause.message) } }
                .collect { userViewState.updateAsync { postSuccess(it) } }
        }
    }
}