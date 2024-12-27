package com.iagoaf.remindapp.modules.newRecipe.di

import android.content.Context
import com.iagoaf.remindapp.core.database.RemindAppDatabase
import com.iagoaf.remindapp.core.domain.repository.IRecipeRepository
import com.iagoaf.remindapp.core.infra.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewRecipeInject {

    @Provides
    @Singleton
    fun providesRecipeRepository(@ApplicationContext context: Context) : IRecipeRepository {
        return RecipeRepositoryImpl(
            RemindAppDatabase.getDatabase(context).recipeDao()
        )
    }


}