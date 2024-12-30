package com.foodics.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.foodics.domain.model.db.CategoryEntity

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: List<CategoryEntity>)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<CategoryEntity>
}
