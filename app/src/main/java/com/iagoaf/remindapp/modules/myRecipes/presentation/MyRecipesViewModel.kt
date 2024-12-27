package com.iagoaf.remindapp.modules.myRecipes.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.iagoaf.remindapp.core.domain.models.RecipeModel
import com.iagoaf.remindapp.core.domain.repository.IRecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyRecipesViewModel @Inject constructor(
    private val recipeRepository: IRecipeRepository
) : ViewModel() {

    val uiState = mutableStateOf<MyRecipesState>(MyRecipesState.Success(emptyList()))

    suspend fun getAll() {
        recipeRepository.getAll().collect { value ->
            uiState.value = MyRecipesState.Success(value)
        }
    }

    suspend fun delete(recipe: RecipeModel) {
        recipeRepository.delete(recipe)
    }

}