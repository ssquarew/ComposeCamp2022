package com.codelabs.basicstatecodelab

import WellnessTaskItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.codelabs.basicstatecodelab.data.WellnessTask

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }


@Composable
fun WellnessTasksList(
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,

    listItems: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = listItems, key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) },
            )
        }
    }
}