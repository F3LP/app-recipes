package com.br.myrecipes.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.br.myrecipes.data.model.Category
import com.br.myrecipes.data.model.Ingredient
import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.data.model.UnitOfMeasurement
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RecipeDAOTest {

    private lateinit var database: RecipeDatabase
    private lateinit var recipeDAO: RecipeDAO
    private lateinit var categoryDAO: CategoryDAO
    private lateinit var unitOfMeasurementDAO: UnitOfMeasurementDAO

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java).build()
        recipeDAO = database.recipeDAO()
        categoryDAO = database.categoryDAO()
        unitOfMeasurementDAO = database.unitOfMeasurementDAO()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testInsertRecipe() = runBlocking {
        categoryDAO.saveCategory(Category(name = "name", namePt = "nome"))
        unitOfMeasurementDAO.saveUnitOfMeasurements(UnitOfMeasurement(name = "colher", namePt = "spoon"))

        val recipeActual = Recipe(
            name = "chocolate cake",
            pictureUrl = "test",
            utensils = "blend",
            serves = 2,
            cookTime = 2,
            directions = "test",
            categoryId = 1
        )

        recipeDAO.saveRecipeWithIngredients(
            recipeActual, listOf(
                Ingredient(
                    name = "ovo",
                    quantity = 4,
                    idUnitOfMeasurement = 1
                )
            )
        )

        val recipeExpected = recipeDAO.getRecipeById(1).first()
        Assert.assertEquals(1L, recipeExpected.recipe.recipeId)
        Assert.assertEquals(recipeActual.name, recipeExpected.recipe.name)
        Assert.assertEquals(recipeActual.categoryId, recipeExpected.recipe.categoryId)
        Assert.assertEquals(recipeActual.directions, recipeExpected.recipe.directions)
        Assert.assertEquals(1, recipeExpected.ingredients.size)
        Assert.assertEquals("ovo", recipeExpected.ingredients[0].name)
    }
}