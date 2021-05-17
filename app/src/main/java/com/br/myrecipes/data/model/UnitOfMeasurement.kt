package com.br.myrecipes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unit_of_measurements")
data class UnitOfMeasurement(
    @PrimaryKey(autoGenerate = true) val unitOfMeasurementId: Long = 0,
    val name: String,
    val namePt: String
)