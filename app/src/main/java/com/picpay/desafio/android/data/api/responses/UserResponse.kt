package com.picpay.desafio.android.data.api.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.picpay.desafio.android.data.database.entities.UserEntity
import com.picpay.desafio.android.models.User
import kotlinx.android.parcel.Parcelize


@Parcelize
data class UserResponse(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
) : Parcelable

fun List<UserResponse>.toDomain(): List<User> {
    return map {
        User(
            id = it.id,
            name = it.name,
            userName = it.username,
            imageUrl = it.img
        )
    }
}

fun List<UserResponse>.toEntity(): List<UserEntity> {
    return map {
        UserEntity(
            id = it.id,
            name = it.name,
            userName = it.username,
            imageUrl = it.img
        )
    }
}