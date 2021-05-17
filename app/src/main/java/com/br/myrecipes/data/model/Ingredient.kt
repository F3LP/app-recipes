package com.br.myrecipes.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients", foreignKeys = [ForeignKey(entity = UnitOfMeasurement::class,
    parentColumns = ["unitOfMeasurementId"], childColumns = ["idUnitOfMeasurement"]),
    ForeignKey(entity = Recipe::class,
        parentColumns = ["recipeId"], childColumns = ["recipeId"])])
data class Ingredient(
    @PrimaryKey(autoGenerate = true) val ingredientId: Long = 0,
    val name: String,
    val quantity: Int,
    val idUnitOfMeasurement: Long,
    var recipeId: Long = 0
)