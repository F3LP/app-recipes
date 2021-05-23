package com.br.myrecipes.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.usecases.GetAllRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(private val useCase: GetAllRecipesUseCase): ViewModel() {

    init {
        getRecipes()
    }

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes

    private fun getRecipes() {
        viewModelScope.launch {
            useCase().collect {
                if(it.isNotEmpty())
                    _recipes.postValue(it)
            }
        }
    }
}