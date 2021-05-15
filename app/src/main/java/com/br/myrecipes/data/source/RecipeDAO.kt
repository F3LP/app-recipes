package com.br.myrecipes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.br.myrecipes.data.model.Ingredient
import com.br.myrecipes.data.model.Recipe

@Dao
interface RecipeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRecipe(recipe: Recipe)

    @Insert
    fun saveIngredents(ingredient: Ingredient)
}