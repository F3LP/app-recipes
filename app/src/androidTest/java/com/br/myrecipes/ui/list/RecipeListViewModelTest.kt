package com.br.myrecipes.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.br.myrecipes.MainCoroutineRule
import com.br.myrecipes.data.model.Category
import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.data.source.RecipeDatabase
import com.br.myrecipes.repository.RecipeRepository
import com.br.myrecipes.runBlockingTest
import com.br.myrecipes.usecases.GetAllRecipesUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.collect
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
class RecipeListViewModelTest {

    private lateinit var recipeDatabase: RecipeDatabase
    private lateinit var recipeListViewModel: RecipeListViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)
        .around(coroutineRule)

    @Inject
    lateinit var useCase: GetAllRecipesUseCase

    @Inject
    lateinit var repository: RecipeRepository

    @Before
    fun setUp() {
        hiltRule.inject()

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        recipeDatabase = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java).build()
        recipeListViewModel = RecipeListViewModel(useCase)
    }

    @After
    fun tearDown() {
        recipeDatabase.close()
    }

    @Test
    fun getRecipes() = coroutineRule.runBlockingTest {
        saveRecipe()
        repository.getAll().collect {
            println("#######")
        }
        //assertTrue(getValue(recipeListViewModel.recipes).size == 5)
    }

    private fun createFakeRecipe() = Recipe(
        name = "chocolate cake",
        pictureUrl = "test",
        utensils = "blend",
        serves = 2,
        cookTime = 2,
        directions = "test",
        categoryId = 1
    )

    private suspend fun saveRecipe() {
        recipeDatabase.categoryDAO().saveCategory(Category(name = "name", namePt = "nome"))
        for (recipe in 1..5) {
            recipeDatabase.recipeDAO().saveRecipe(createFakeRecipe())
        }
        println("&&&&")
    }
}