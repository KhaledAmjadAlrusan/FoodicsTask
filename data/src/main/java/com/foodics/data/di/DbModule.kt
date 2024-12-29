package com.foodics.data.di

import androidx.room.Room
import com.foodics.data.db.AppDatabase
import org.koin.dsl.module

val dbModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_db").build() }
    single { get<AppDatabase>().categoryDao() }
    single { get<AppDatabase>().productDao() }
    single { get<AppDatabase>().cartDao() }
}