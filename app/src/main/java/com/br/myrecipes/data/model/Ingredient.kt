package com.br.myrecipes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ingredient")
data class Ingredient (
    @PrimaryKey(autoGenerate = true) val ingredientId: Int,
    val name: String,
    val quantity: Int,
    val idUnitOfMeasurement: Long
    )