package com.iagoaf.remindapp.core.infra.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.iagoaf.remindapp.core.domain.models.RecipeModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipe: RecipeModel)

    @Update
    suspend fun update(recipe: RecipeModel)

    @Delete
    suspend fun delete(recipe: RecipeModel)

    @Query("SELECT * FROM items")
    fun getAll(): Flow<List<RecipeModel>>

}