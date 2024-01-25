package com.example.basicstatecodelab.domian

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.presentation.composables.WellnessTaskItem


@Composable
fun WellnessTaskList(
    list: List <WellnessTask>,
    onCheckedTask: (WellnessTask,Boolean) -> Unit,
    onCloseTask : (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = Modifier) {
        items(items = list, key = {task -> task.id}) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedTask = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}