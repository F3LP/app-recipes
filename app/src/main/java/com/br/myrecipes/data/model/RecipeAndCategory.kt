package com.br.myrecipes.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class RecipeAndCategory(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "category_id"
    )
    val recipe: Recipe
)
