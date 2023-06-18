package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.lduboscq.appkickstarter.model.Person

@Composable
fun PersonList(personList: List<Person>){
    var personListState = remember { mutableStateListOf<Person>() }
    personListState.addAll(personList)

    val handleEditClick: (Person) -> Unit = { person ->
        val idx: Int = personListState.indexOfFirst {it.id == person.id}
        if (idx > -1) {
            personListState[idx] = person
        }
    }

    val handleDeleteClick: (Person) -> Unit = { person ->
        personListState.remove(person)
    }

    LazyColumn {
        items(personListState){
            PersonCard(person = it, onEditClick = handleEditClick, onDeleteClick = handleDeleteClick)
        }
    }
}