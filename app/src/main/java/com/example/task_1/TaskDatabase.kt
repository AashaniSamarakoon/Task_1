package com.example.task_1

//import androidx.room.Database
//import androidx.room.RoomDatabase
//
//
//@Database(entities = [Task::class], version = 1)
//abstract class TaskDatabase : RoomDatabase() {
//    abstract fun taskDao(): TaskDao
//}
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao // Replace with your actual Dao interface

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_database" // Replace with your desired database name
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}