package com.picpay.desafio.android.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.extensions.updateAsync
import com.picpay.desafio.android.user.repository.UserRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository): ViewModel() {

    private val _state = MutableLiveData(UserViewState())
    val state: LiveData<UserViewState>
        get() = _state

    fun getUsers() {
        viewModelScope.launch {
            repository.getUsers()
                .catch { cause -> _state.updateAsync { postError(cause.message) } }
                .collect { _state.updateAsync { postSuccess(it) } }
        }
    }
}