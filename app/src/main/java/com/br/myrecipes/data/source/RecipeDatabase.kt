package com.br.myrecipes.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.br.myrecipes.data.model.Category
import com.br.myrecipes.data.model.Ingredient
import com.br.myrecipes.data.model.Recipe
import com.br.myrecipes.data.model.UnitOfMeasurement

@Database(
    entities = [Recipe::class, Ingredient::class, Category::class, UnitOfMeasurement::class],
    version = 1, exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDAO(): RecipeDAO
    abstract fun categoryDAO(): CategoryDAO

    // abstract fun ingredientDAO(): IngredientDAO
    abstract fun unitOfMeasurementDAO(): UnitOfMeasurementDAO

    companion object {

        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getInstance(context: Context): RecipeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java,
                    "recipe_db"

                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        getInstance(context).categoryDAO().saveCategory(category = Category(name = "Breakfast", namePt = "Café da manhã"))
                        getInstance(context).categoryDAO().saveCategory(category = Category(name = "Lunch", namePt = "Almoço"))
                        getInstance(context).categoryDAO().saveCategory(category = Category(name = "Dinner", namePt = "Jantar"))
                        getInstance(context).categoryDAO().saveCategory(category = Category(name = "Desserts", namePt = "Sobremesa"))

                        getInstance(context).unitOfMeasurementDAO().saveUnitOfMeasurements(
                            UnitOfMeasurement(name = "Table Spoon", namePt = "Colher de Sopa")
                        )
                        getInstance(context).unitOfMeasurementDAO().saveUnitOfMeasurements(
                            UnitOfMeasurement(name = "Tea Spoon", namePt = "Colher de Chá")
                        )
                        getInstance(context).unitOfMeasurementDAO().saveUnitOfMeasurements(
                            UnitOfMeasurement(name = "Cup", namePt = "Xícara")
                        )
                        getInstance(context).unitOfMeasurementDAO().saveUnitOfMeasurements(
                            UnitOfMeasurement(name = "Kg", namePt = "Kg")
                        )
                        getInstance(context).unitOfMeasurementDAO().saveUnitOfMeasurements(
                            UnitOfMeasurement(name = "g", namePt = "g")
                        )
                    }
                })
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
