package com.br.myrecipes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.br.myrecipes.data.model.UnitOfMeasurement
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitOfMeasurementDAO {

    @Insert
    fun saveUnitOfMeasurements(unitOfMeasurement: UnitOfMeasurement)

//    // ****** necessário?
//    @Query("SELECT * FROM unit_of_measurement WHERE unitOfMeasurementId = :id")
//    fun getUnitOfMeasurementById(id: Int): Flow<UnitOfMeasurementDAO>

    @Query("SELECT * FROM unit_of_measurements")
    fun getAllUnitOfMeasurement(): Flow<List<UnitOfMeasurement>>
}
