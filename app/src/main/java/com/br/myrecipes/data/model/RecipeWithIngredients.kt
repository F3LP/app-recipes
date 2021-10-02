package com.br.myrecipes.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeWithIngredients(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "recipe_id"
    )
    val ingredients: List<Ingredient>
)
