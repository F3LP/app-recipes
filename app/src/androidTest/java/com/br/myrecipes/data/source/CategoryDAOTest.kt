package com.br.myrecipes.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.br.myrecipes.data.model.Category
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryDAOTest {

    private lateinit var database: RecipeDatabase
    private lateinit var categoryDAO: CategoryDAO

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java).build()
        categoryDAO = database.categoryDAO()
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetCategory() = runBlocking {
        val expected = Category(name ="name", namePt = "nome")

        categoryDAO.saveCategory(expected)
        val category = categoryDAO.getCategoryById(1).first()

        assertEquals(1L, category.categoryId)
        assertEquals(expected.name, category.name)
        assertEquals(expected.namePt, category.namePt)
    }
}