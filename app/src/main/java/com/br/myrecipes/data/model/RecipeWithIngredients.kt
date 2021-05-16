package com.br.myrecipes.data.model

import androidx.room.Embedded
import androidx.room.Relation

//@Entity(tableName = "recipe_and_ingredients")
data class RecipeWithIngredients (
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "ingredientId"
    )
    val ingredients: List<Ingredient>
)
