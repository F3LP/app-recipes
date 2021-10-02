package com.br.myrecipes.usecases

import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(private val repository: RecipeRepository) {

    operator fun invoke(): Flow<List<Recipe>> {
        return repository.getAllRepository()
    }
}
