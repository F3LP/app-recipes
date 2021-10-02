package com.br.myrecipes.repository

import com.br.myrecipes.data.source.RecipeDataSource
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class RecipeRepositoryTest {

    private val datasource: RecipeDataSource = mock()
    private lateinit var repository: RecipeRepository

    @Before
    fun setup() {
        repository = RecipeRepository(datasource)
    }

    @Test
    fun getAllRecipes() {
        repository.getAllRepository()
        verify(datasource, times(1)).getAllRecipes()
    }
}
