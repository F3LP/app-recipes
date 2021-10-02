package com.br.myrecipes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ingredients",
    foreignKeys = [
        ForeignKey(
            entity = UnitOfMeasurement::class,
            parentColumns = ["unit_of_measurement_id"], childColumns = ["unit_of_measurement_id"]
        ),
        ForeignKey(
            entity = Recipe::class,
            parentColumns = ["recipe_id"], childColumns = ["recipe_id"]
        )
    ]
)
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ingredient_id")
    val ingredientId: Long = 0,
    val name: String,
    val quantity: Int,
    @ColumnInfo(name = "unit_of_measurement_id", index = true)
    val idUnitOfMeasurement: Long,
    @ColumnInfo(name = "recipe_id", index = true)
    var recipeId: Long = 0
)
