package com.br.myrecipes.usecases

import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class GetAllRecipesUseCase(private val repository: RecipeRepository) {

    operator fun invoke(): Flow<List<Recipe>> = repository.getAll()

}