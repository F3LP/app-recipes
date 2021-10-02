package com.br.myrecipes.repository

import com.br.myrecipes.data.source.UnitOfMeasurementDataSource
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class UnitOfMeasurementRepositoryTest {

    private val datasource: UnitOfMeasurementDataSource = mock()
    private lateinit var repository: UnitOfMeasurementRepository

    @Before
    fun setup() {
        repository = UnitOfMeasurementRepository(datasource)
    }

    @Test
    fun getAllUnitOfMeasurement() {
        repository.getAllUnitOfMeasurement()
        verify(datasource, times(1)).getAllUnitOfMeasurement()
    }
}
