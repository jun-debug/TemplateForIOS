package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.lduboscq.appkickstarter.model.Person
import com.lduboscq.appkickstarter.ui.Image

@Composable
fun PersonCard(person: Person,
               onClick: (Person) -> Unit = {},
               onEditClick: (Person) -> Unit = {},
               onDeleteClick: (Person) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 6.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                url = person.imageUrl,
                contentDescription = person.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(text = person.name, fontWeight = FontWeight.Bold)
                Text(text = person.role)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { onEditClick(person) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = { onDeleteClick(person) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}
