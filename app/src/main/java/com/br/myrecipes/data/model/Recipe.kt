package com.br.myrecipes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "recipes",
    foreignKeys = [
        ForeignKey(
            entity = Category::class, parentColumns = ["category_id"],
            childColumns = ["category_id"]
        )
    ]
)
class Recipe(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recipe_id")
    val recipeId: Long = 0,
    val name: String,
    val pictureUrl: String,
    val utensils: String,
    val serves: Int,
    @ColumnInfo(name = "cook_time") val cookTime: Int,
    val directions: String,
    @ColumnInfo(name = "category_id", index = true)
    val categoryId: Long
)
