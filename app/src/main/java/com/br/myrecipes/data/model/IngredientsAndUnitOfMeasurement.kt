package com.br.myrecipes.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class IngredientsAndUnitOfMeasurement(
    @Embedded
    val unitOfMeasurement: UnitOfMeasurement,
    @Relation(
        parentColumn = "ingredients_id",
        entityColumn = "unit_of_measurement_id"
    )
    val ingredient: Ingredient
)