package com.example.basicstatecodelab.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.domian.WellnessTask
import com.example.basicstatecodelab.domian.WellnessTaskList
import com.example.basicstatecodelab.presentation.composables.StatefulCounter

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel() // this declaration uses and existing viewmodel or creates a new one
){
    Column(modifier = Modifier) {
        StatefulCounter(modifier)
        WellnessTaskList(
            // should only pass data that is needed rather than the whole viewmodel

            // named parameters need to match. Best to use named parameters for readability
            list = wellnessViewModel.tasks,
            onCheckedTask = {task, value ->
                wellnessViewModel.changeTaskCheck(task, value)
            },
            onCloseTask = { task ->
                wellnessViewModel.removeTask(task)
            }
        )
    }
}

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

