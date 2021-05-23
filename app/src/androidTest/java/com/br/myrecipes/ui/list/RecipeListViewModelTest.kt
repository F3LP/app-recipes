package com.br.myrecipes.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.br.myrecipes.MainCoroutineRule
import com.br.myrecipes.data.model.Category
import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.data.source.CategoryDAO
import com.br.myrecipes.data.source.RecipeDAO
import com.br.myrecipes.runBlockingTest
import com.br.myrecipes.usecases.GetAllRecipesUseCase
import com.br.myrecipes.utilities.getValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

@Suppress("BlockingMethodInNonBlockingContext")
@HiltAndroidTest
class RecipeListViewModelTest {

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
    lateinit var categoryDAO: CategoryDAO

    @Inject
    lateinit var recipeDAO: RecipeDAO

    @Before
    fun setUp() {
        hiltRule.inject()
        recipeListViewModel = RecipeListViewModel(useCase)
    }


    @Test
    fun getRecipes() = coroutineRule.runBlockingTest {
        saveRecipe()
        assertTrue(getValue(recipeListViewModel.recipes).size == 5)
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
        categoryDAO.saveCategory(Category(name = "name", namePt = "nome"))
        for (recipe in 1..5) {
            recipeDAO.saveRecipe(createFakeRecipe())
        }
    }
}