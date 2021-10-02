package com.br.myrecipes.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import com.br.myrecipes.data.model.Ingredient

@Dao
interface IngredientDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    fun saveIngredients(ingredient: List<Ingredient>)

//    @Query("SELECT * FROM ingredient WHERE ingredientId = :id")
//    fun getIngredientById(id: Int): Flow<Ingredient>
//
//    @Query("SELECT * FROM ingredient")
//    fun getAllIngredients(): Flow<Ingredient>
}
