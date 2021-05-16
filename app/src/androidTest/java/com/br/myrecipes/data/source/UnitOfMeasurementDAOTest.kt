package com.br.myrecipes.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.br.myrecipes.data.model.UnitOfMeasurement
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UnitOfMeasurementDAOTest {

    private lateinit var database: RecipeDatabase
    private lateinit var unitOfMeasurementDAO: UnitOfMeasurementDAO

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java).build()
        unitOfMeasurementDAO = database.unitOfMeasurementDAO()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testSaveRecipeAndIngredients() = runBlocking {

        val expected = UnitOfMeasurement( name ="colher", namePt = "spoon")
        val expected2 = UnitOfMeasurement( name ="kg", namePt = "kg")

        unitOfMeasurementDAO.saveUnitOfMeasurements(expected)
        unitOfMeasurementDAO.saveUnitOfMeasurements(expected2)

        val listUnit = unitOfMeasurementDAO.getAllUnitOfMeasurement().first()

        assertEquals(1, listUnit[0].unitOfMeasurementId)
        assertEquals(expected.name, listUnit[0].name)
        assertEquals(expected.namePt, listUnit[0].namePt)
    }
}