package com.br.myrecipes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitOfMeasurement {

    @Insert
    fun saveUnitOfMeasurements(ingredient: UnitOfMeasurement)

    // ****** necessário?
    @Query("SELECT * FROM unit_of_measurement WHERE unitOfMeasurementId = :id")
    fun getUnitOfMeasurementById(id: Int): Flow<UnitOfMeasurement>

    @Query("SELECT * FROM unit_of_measurement")
    fun getAllUnitOfMeasurementById(): Flow<UnitOfMeasurement>

}