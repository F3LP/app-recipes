package com.br.myrecipes.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(tableName = "ingredients_and_unit_of_measurement")
data class IngredientsAndUnitOfMeasurement (
    @Embedded
    val unitOfMeasurement: UnitOfMeasurement,
    @Relation(
        parentColumn = "ingredientsId",
        entityColumn = "idUnitOfMeasurement"
    )
    val ingredient: Ingredient
)