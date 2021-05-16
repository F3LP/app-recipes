package com.br.myrecipes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.myrecipes.data.model.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe WHERE recipeId = :id")
    fun getRecipeById(id: Int): Flow<Recipe>

}