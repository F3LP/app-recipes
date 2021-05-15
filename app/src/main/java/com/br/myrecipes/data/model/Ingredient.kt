package com.br.myrecipes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ingredients")
data class Ingredient (
    @PrimaryKey(autoGenerate = true) val ingredientsId: Int,
    val name: String,
    val quantity: Int,
    val idUnitOfMeasurement: Long
    )