package com.codelabs.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelabs.basicstatecodelab.data.WellnessTask
import com.codelabs.basicstatecodelab.viewmodel.WellnessViewModel

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "할일 웰 # $i") }


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier, wellnessViewModel: WellnessViewModel = viewModel()
) {
    WaterCounter(modifier)

    WellnessTasksList(
        listItems = wellnessViewModel.tasks, onCloseTask = { task -> wellnessViewModel.remove(task) },
        onCheckedTask = { task, checked ->
            wellnessViewModel.changeTaskChecked(task, checked)
        },
    )
}