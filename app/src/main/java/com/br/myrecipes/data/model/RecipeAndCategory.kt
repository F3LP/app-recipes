package com.br.myrecipes.data.model

import androidx.room.Embedded
import androidx.room.Relation

//@Entity(tableName = "recipe_category")
data class RecipeAndCategory (
    @Embedded val category: Category,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "categoryId"
    )
    val recipe: Recipe
)