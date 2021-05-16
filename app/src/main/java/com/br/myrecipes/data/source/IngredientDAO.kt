package com.br.myrecipes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.myrecipes.data.model.Ingredient
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveIngredients(ingredient: Ingredient) {
    }

    @Query("SELECT * FROM ingredient WHERE ingredientId = :id")
    fun getIngredientById(id: Int): Flow<Ingredient>
//
//    @Query("SELECT * FROM ingredient")
//    fun getAllIngredients(): Flow<Ingredient>

}
