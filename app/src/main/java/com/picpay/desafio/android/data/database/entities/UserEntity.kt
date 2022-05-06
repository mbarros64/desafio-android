package com.picpay.desafio.android.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.picpay.desafio.android.models.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "username")
    var userName: String,

    @ColumnInfo(name = "image_url")
    var imageUrl: String
)

fun List<UserEntity>.toDomain(): List<User> {
    return map {
        User(
            id = it.id,
            name = it.name,
            userName = it.userName,
            imageUrl = it.imageUrl
        )
    }
}