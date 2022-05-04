package com.picpay.desafio.android.user.network

suspend fun <T> safeDataRequest(function: suspend () -> T): ResultWrapper<T> {
    return try {
        ResultWrapper.Success(function())
    } catch (throwable: Throwable) {
        ResultWrapper.Error(throwable)
    }
}