import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.lduboscq.appkickstarter.main.Task

@Composable
fun ListLab( tasks: List<Task> = remember { getTaskList() }){
    LazyColumn(

    ) {
        items(tasks) { task -> TaskItem(task.title)
        }
    }
}

private fun getTaskList() = List(30) { i -> Task( i, "com.lduboscq.appkickstarter.main.Task $i") }