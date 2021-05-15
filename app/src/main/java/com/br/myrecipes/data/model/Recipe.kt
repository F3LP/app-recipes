package com.br.myrecipes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
class Recipe (
    @PrimaryKey(autoGenerate = true) val recipeId: Int,
    val name: String,
    val pictureUrl: String,
    val utensils: String,
    val serves: Int,
    @ColumnInfo(name = "cook_time") val cookTime: Int,
    val directions: String,
    val categoryId: Long
)


