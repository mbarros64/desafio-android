package com.picpay.desafio.android.di

import androidx.room.Room
import com.picpay.desafio.android.user.database.AppDatabase
import com.picpay.desafio.android.network.RetrofitFactory
import com.picpay.desafio.android.user.network.UserService
import com.picpay.desafio.android.user.repository.UserRepository
import com.picpay.desafio.android.user.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { UserRepository(get(), get()) }
    viewModel { UserViewModel(get()) }

    single { Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "picpay-database")
        .fallbackToDestructiveMigration()
        .build() }
    factory { get<AppDatabase>().userDao() }
    factory { RetrofitFactory.build(UserService::class.java) }
}