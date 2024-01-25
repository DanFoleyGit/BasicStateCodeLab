package com.example.basicstatecodelab.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.basicstatecodelab.domian.WellnessTask

class WellnessViewModel: ViewModel() {

    // To react to a change in state, an object needs to be MutableState<T> and can be assigned like
    // var name: MutableState<String> = mutableStateOf("Dan")

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun removeTask(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun changeTaskCheck(task: WellnessTask, value: Boolean) {
        _tasks.find { it.id == task.id }?.let {
            task.checked = value
        }
    }

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

}