package com.br.myrecipes.repository

import com.br.myrecipes.data.source.RecipeDAO
import com.br.myrecipes.data.model.Recipe

class RecipeRepository(private val recipeDAO: RecipeDAO) {

    fun saveRecipe(recipe: Recipe) = recipeDAO.saveRecipe(recipe)
}