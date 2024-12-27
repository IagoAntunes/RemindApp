package com.iagoaf.remindapp.modules.newRecipe.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.iagoaf.remindapp.core.domain.models.RecipeModel
import com.iagoaf.remindapp.core.domain.repository.IRecipeRepository
import com.iagoaf.remindapp.core.infra.dao.RecipeDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewRecipeViewModel @Inject constructor(
    val recipeRepository: IRecipeRepository,
) : ViewModel() {

    var uiState = mutableStateOf<NewRecipeState>(NewRecipeState.Idle)
        private set

    suspend fun addRecipe(
        name: String,
        time: String,
        recurrence: String
    ){
        uiState.value = NewRecipeState.Loading
        val recipeModel = RecipeModel(
            name = name,
            time = time,
            recurrence = recurrence
        )
        recipeRepository.createRecipe(recipeModel)
        uiState.value = NewRecipeState.Success
    }

}