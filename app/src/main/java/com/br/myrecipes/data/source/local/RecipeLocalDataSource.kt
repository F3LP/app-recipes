package com.br.myrecipes.data.source.local

import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.data.source.RecipeDAO
import com.br.myrecipes.data.source.RecipeDataSource
import kotlinx.coroutines.flow.Flow

class RecipeLocalDataSource(private val recipeDao: RecipeDAO): RecipeDataSource {


    override fun getAllRecipes(): Flow<List<Recipe>> =
        recipeDao.getAll()

}