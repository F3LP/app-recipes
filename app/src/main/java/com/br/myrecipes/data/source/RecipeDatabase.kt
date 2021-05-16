package com.br.myrecipes.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.br.myrecipes.data.model.Category
import com.br.myrecipes.data.model.Ingredient
import com.br.myrecipes.data.model.Recipe

@Database(entities = [Recipe::class, Ingredient::class, Category::class, UnitOfMeasurement::class], version = 1)
abstract class RecipeDatabase: RoomDatabase() {

    abstract fun recipeDAO(): RecipeDAO
    abstract fun categoryDAO(): CategoryDAO
    abstract fun ingredientDAO(): IngredientDAO

    companion object {

        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getDatabase(context: Context): RecipeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java,
                    "recipe_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}