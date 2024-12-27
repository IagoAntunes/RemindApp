package com.iagoaf.remindapp.core.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class RecipeModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val time: String,
    val recurrence: String
)