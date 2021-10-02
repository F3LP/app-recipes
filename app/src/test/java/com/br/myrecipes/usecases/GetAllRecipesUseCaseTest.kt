package com.br.myrecipes.usecases

import com.br.myrecipes.repository.RecipeRepository
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class GetAllRecipesUseCaseTest {

    private val repository: RecipeRepository = mock()
    private lateinit var useCase: GetAllRecipesUseCase

    @Before
    fun setup() {
        useCase = GetAllRecipesUseCase(repository)
    }

    @Test
    operator fun invoke() {
        useCase()
        verify(repository, times(1)).getAllRepository()
    }
}
