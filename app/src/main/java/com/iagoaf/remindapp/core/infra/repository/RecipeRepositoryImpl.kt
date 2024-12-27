package com.iagoaf.remindapp.core.infra.repository

import com.iagoaf.remindapp.core.domain.models.RecipeModel
import com.iagoaf.remindapp.core.domain.repository.IRecipeRepository
import com.iagoaf.remindapp.core.infra.dao.RecipeDao
import kotlinx.coroutines.flow.Flow

class RecipeRepositoryImpl(
    private val recipeDao: RecipeDao
) : IRecipeRepository {
    override suspend fun createRecipe(recipeModel: RecipeModel) {
        return recipeDao.insert(recipeModel)
    }

    override suspend fun delete(recipeModel: RecipeModel) {
        return recipeDao.delete(recipeModel)
    }

    override suspend fun getAll(): Flow<List<RecipeModel>> {
        return recipeDao.getAll()
    }
}