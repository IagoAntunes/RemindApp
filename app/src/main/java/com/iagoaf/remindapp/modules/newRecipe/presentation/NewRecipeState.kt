package com.iagoaf.remindapp.modules.newRecipe.presentation

sealed class NewRecipeState {
    object Loading : NewRecipeState()
    object Success : NewRecipeState()
    object Error : NewRecipeState()
    object Idle : NewRecipeState()
}