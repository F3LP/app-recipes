package com.br.myrecipes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.br.myrecipes.data.model.Ingredient
import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.data.model.RecipeWithIngredients
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RecipeDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipeWithIngredients(recipe: Recipe, ingredients: List<Ingredient>) {
        val recipeId = saveRecipe(recipe)
        ingredients.forEach { ingredient ->  ingredient.recipeId = recipeId }
        saveIngredients(ingredients)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveRecipe(recipe: Recipe): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveIngredients(ingredients: List<Ingredient>)

    @Query("SELECT * FROM recipes WHERE recipeId = :id")
    abstract fun getRecipeById(id: Int): Flow<RecipeWithIngredients>

}