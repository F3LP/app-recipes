package com.br.myrecipes.data.source

import com.br.myrecipes.data.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeDataSource {

    fun getAllRecipes(): Flow<List<Recipe>>
}