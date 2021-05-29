package com.br.myrecipes.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class IngredientDAOTest {

    private lateinit var database: RecipeDatabase
    private lateinit var ingredientDAO: IngredientDAO

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java).build()
        //ingredientDAO = database.ingredientDAO()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetIngredient() = runBlocking {

//        val unitOfMeasurement = UnitOfMeasurement(1, "colher", "spoon")
//
//        val expected = Ingredient(1, "leite", 1, unitOfMeasurement.unitOfMeasurementId ?: 0)
//        ingredientDAO.saveIngredient(expected)
//        val actual = ingredientDAO.getIngredientById(1).first()
//
//        Assert.assertEquals(expected, actual)
    }


}