package com.foodics.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.foodics.data.db.dao.CartDao
import com.foodics.data.db.dao.CategoryDao
import com.foodics.data.db.dao.ProductDao
import com.foodics.domain.model.db.CartEntity
import com.foodics.domain.model.db.CategoryEntity
import com.foodics.domain.model.db.ProductEntity

@Database(
    entities = [CategoryEntity::class, ProductEntity::class, CartEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao
    abstract fun cartDao(): CartDao
}
