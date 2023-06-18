package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.lduboscq.appkickstarter.model.Person

@Composable
fun AddPersonContent(person: Person, onSavePerson: (Person) -> Unit, onDone:()-> Unit) {
    var name by remember { mutableStateOf(person.name) }
    var role by remember { mutableStateOf(person.role) }
    var imageUrl by remember { mutableStateOf("https://www.akronzoo.org/sites/default/files/styles/square_large/public/assets/animals/Tiger-main.png?h=00546c34&itok=0LXXy7LI") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Name") },
            leadingIcon = { Icon(Icons.Filled.Face, contentDescription = "Name") }
        )
        OutlinedTextField(
            value = role,
            onValueChange = { role = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Role") },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Role") }
        )
        OutlinedTextField(
            value = imageUrl,
            onValueChange = { imageUrl = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Image url") },
            leadingIcon = { Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "person image") }
        )
        Row(modifier = Modifier.fillMaxWidth().padding(30.dp), ) {
            Button(
                onClick = {
                    val newPerson : Person = Person(person.id, name, role, imageUrl)
                    onSavePerson(newPerson)
                }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Send, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Save", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(
                onClick = { onDone() }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Done, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Done", color = Color.White)
                }
            }
        }

    }
}
