import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RestoreStateLab(){
    var count by rememberSaveable { mutableStateOf(0) }
    Column {
        if (count > 0){
            Text("Count: $count")
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = {count++}, enabled = count < 10){
            Text("Add")
        }
        Spacer(Modifier.height(20.dp))
        Button(onClick = {count = 0}, enabled = count > 0){
            Text("Clear")
        }
    }
}