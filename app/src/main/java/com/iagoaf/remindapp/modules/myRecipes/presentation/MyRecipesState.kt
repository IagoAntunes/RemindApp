package com.iagoaf.remindapp.modules.myRecipes.presentation

import com.iagoaf.remindapp.core.domain.models.RecipeModel

sealed class MyRecipesState(
) {
    object Loading : MyRecipesState()
    data class Success(
        val recipes: List<RecipeModel>
    ) : MyRecipesState()
    object Error : MyRecipesState()
    object Idle : MyRecipesState()

}