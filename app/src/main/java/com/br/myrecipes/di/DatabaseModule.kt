package com.br.myrecipes.di

import android.content.Context
import com.br.myrecipes.data.source.CategoryDAO
import com.br.myrecipes.data.source.RecipeDAO
import com.br.myrecipes.data.source.RecipeDataSource
import com.br.myrecipes.data.source.RecipeDatabase
import com.br.myrecipes.data.source.UnitOfMeasurementDAO
import com.br.myrecipes.data.source.local.RecipeLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return RecipeDatabase.getInstance(context)
    }

    @Provides
    fun provideRecipeDAO(recipeDatabase: RecipeDatabase): RecipeDAO {
        return recipeDatabase.recipeDAO()
    }

    @Provides
    fun provideRecipeDatasource(recipeDAO: RecipeDAO): RecipeDataSource {
        return RecipeLocalDataSource(recipeDAO)
    }

    @Provides
    fun provideCategoryDAO(recipeDatabase: RecipeDatabase): CategoryDAO {
        return recipeDatabase.categoryDAO()
    }

    @Provides
    fun provideUnitOfMeasurementDAO(recipeDatabase: RecipeDatabase): UnitOfMeasurementDAO {
        return recipeDatabase.unitOfMeasurementDAO()
    }
}
