package com.br.myrecipes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "recipe", foreignKeys = [ForeignKey(entity = Category::class, parentColumns = ["categoryId"], childColumns = ["categoryId"])])
class Recipe (
    @PrimaryKey(autoGenerate = true) val recipeId: Long? = null,
    val name: String,
    val pictureUrl: String,
    val utensils: String,
    val serves: Int,
    @ColumnInfo(name = "cook_time") val cookTime: Int,
    val directions: String,
    val categoryId: Long
)




