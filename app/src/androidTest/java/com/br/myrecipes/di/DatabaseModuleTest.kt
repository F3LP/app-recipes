package com.br.myrecipes.di

import android.content.Context
import androidx.room.Room
import com.br.myrecipes.data.source.CategoryDAO
import com.br.myrecipes.data.source.RecipeDAO
import com.br.myrecipes.data.source.RecipeDataSource
import com.br.myrecipes.data.source.RecipeDatabase
import com.br.myrecipes.data.source.local.RecipeLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.testing.TestInstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
@Module
class DatabaseModuleTest {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java).build()
    }

    @Provides
    fun provideRecipeDAO(recipeDatabase: RecipeDatabase): RecipeDAO {
        return recipeDatabase.recipeDAO()
    }

    @Provides
    fun provideCategoryDAO(recipeDatabase: RecipeDatabase): CategoryDAO {
        return recipeDatabase.categoryDAO()
    }

    @Provides
    fun provideRecipeDatasource(recipeDAO: RecipeDAO): RecipeDataSource {
        return RecipeLocalDataSource(recipeDAO)
    }

}