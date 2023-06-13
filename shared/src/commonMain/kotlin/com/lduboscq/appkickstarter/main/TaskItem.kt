import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(
    taskName: String,
    checked : Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
){
    Row {
        Text("$taskName")
        Spacer(Modifier.width(15.dp))
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Composable
fun TaskItem(taskName: String){
    var checkedState by remember { mutableStateOf(false) }
    TaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = {checkedState = it})
}