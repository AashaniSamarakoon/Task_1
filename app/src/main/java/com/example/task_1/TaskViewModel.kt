package com.example.task_1


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow




class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    // Insert a task into the database
    fun insert(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(task)
        }
    }

    // Update a task in the database
    fun update(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(task)
        }
    }

    // Delete a task from the database
    fun delete(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(task)
        }
    }

//    // Get all tasks from the repository
//   fun getAllTasks(): LiveData<List<Task>> {
//        return repository.getAllTasks() // Replace with your actual implementation
//    }
}
