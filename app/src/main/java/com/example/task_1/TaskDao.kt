package com.example.task_1

import androidx.room.Dao
import androidx.room.Insert

import androidx.room.Query

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM tasks ORDER BY priority DESC")
    fun getAllTasks(): LiveData<List<Task>>
}


