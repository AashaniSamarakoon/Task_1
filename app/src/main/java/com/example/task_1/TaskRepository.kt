package com.example.task_1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }

    suspend fun update(task: Task) {
        taskDao.update(task)
    }

    suspend fun delete(task: Task) {
        taskDao.delete(task)
    }

    suspend fun getAllTasks(): LiveData<List<Task>> {
        return withContext(Dispatchers.IO) {
            taskDao.getAllTasks()
        }
    }
}
