
package com.example.task_1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import com.example.task_1.TaskViewModel
import com.example.task_1.TaskAdapter
import com.example.task_1.TaskDatabase
import com.example.task_1.TaskRepository
import com.example.task_1.R


class MainActivity : AppCompatActivity() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskAdapter = TaskAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_tasks)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = taskAdapter
        }

        // Create an instance of TaskDatabase (you need to implement this class)
        val taskDatabase = TaskDatabase.getDatabase(applicationContext)

        // Create an instance of TaskRepository (you need to implement this class)
        val repository = TaskRepository(taskDatabase.taskDao())

        // Create a ViewModel using the ViewModelProvider
        taskViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(TaskViewModel::class.java)

        // Call getAllTasks() from a coroutine scope
//        taskViewModel.getAllTasks().observe(this, { tasks ->
//            taskAdapter.submitList(tasks)
//        })

        // Implement any additional logic as needed
    }

}
