package com.iagoaf.remindapp.core.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iagoaf.remindapp.core.domain.models.RecipeModel
import com.iagoaf.remindapp.core.infra.dao.RecipeDao

@Database(entities = [RecipeModel::class],version = 1, exportSchema = false)
abstract class RemindAppDatabase : RoomDatabase(){


    abstract fun recipeDao() : RecipeDao

    companion object{
        @Volatile
        private var instance: RemindAppDatabase? = null

        fun getDatabase(context: Context): RemindAppDatabase{
            return instance ?: synchronized(this) {
                Log.i("RemindAppDatabase", "Creating new database instance")
                Room.databaseBuilder(context, RemindAppDatabase::class.java, "item_database")
                    .build()
                    .also {
                        instance = it
                        Log.i("RemindAppDatabase", "created new database instance")
                    }
            }
        }
    }

}