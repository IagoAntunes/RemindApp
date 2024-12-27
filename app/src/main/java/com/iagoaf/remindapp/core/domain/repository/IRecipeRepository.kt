package com.iagoaf.remindapp.core.domain.repository

import com.iagoaf.remindapp.core.domain.models.RecipeModel
import kotlinx.coroutines.flow.Flow

interface IRecipeRepository {

    suspend fun createRecipe(recipeModel: RecipeModel)
    suspend fun delete(recipeModel: RecipeModel)
    suspend fun getAll(): Flow<List<RecipeModel>>

}