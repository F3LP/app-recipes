package com.br.myrecipes.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "ingredient", foreignKeys = [ForeignKey(entity = UnitOfMeasurement::class, parentColumns = ["unitOfMeasurementId"], childColumns = ["idUnitOfMeasurement"])])
data class Ingredient (
    @PrimaryKey(autoGenerate = true) val ingredientId: Long? = null,
    val name: String,
    val quantity: Int,
    val idUnitOfMeasurement: Long
    )