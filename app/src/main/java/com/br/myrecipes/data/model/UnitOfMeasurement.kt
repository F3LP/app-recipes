package com.br.myrecipes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unit_of_measurement")
data class UnitOfMeasurement(
    @PrimaryKey(autoGenerate = true) val unitOfMeasurementId: Int,
    val name: String,
    val namePt: String
)