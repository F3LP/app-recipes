package com.br.myrecipes.repository

import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.data.source.RecipeDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository @Inject constructor(private val recipeDataSource: RecipeDataSource) {

    fun getAll(): Flow<List<Recipe>> = recipeDataSource.getAllRecipes()

}