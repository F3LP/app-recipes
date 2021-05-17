package com.br.myrecipes.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class IngredientsAndUnitOfMeasurement(
    @Embedded
    val unitOfMeasurement: UnitOfMeasurement,
    @Relation(
        parentColumn = "ingredientsId",
        entityColumn = "idUnitOfMeasurement"
    )
    val ingredient: Ingredient
)