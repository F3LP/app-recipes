package com.br.myrecipes.di

import android.content.Context
import com.br.myrecipes.data.source.RecipeDAO
import com.br.myrecipes.data.source.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return RecipeDatabase.getInstance(context)
    }

    @Provides
    fun provideRecipeDAO(recipeDatabase: RecipeDatabase): RecipeDAO {
        return recipeDatabase.recipeDAO()
    }

//    @Provides
//    fun provideRecipeDatasource(recipeDAO: RecipeDAO): RecipeDataSource {
//        return RecipeLocalDataSource(recipeDAO)
//    }
}