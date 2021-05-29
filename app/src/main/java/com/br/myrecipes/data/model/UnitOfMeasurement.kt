package com.br.myrecipes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unit_of_measurements")
data class UnitOfMeasurement(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "unit_of_measurement_id")
    val unitOfMeasurementId: Long = 0,
    val name: String,
    @ColumnInfo(name = "name_pt")
    val namePt: String
)