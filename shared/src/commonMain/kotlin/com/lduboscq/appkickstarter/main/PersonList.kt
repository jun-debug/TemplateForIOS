package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.lduboscq.appkickstarter.model.Person

@Composable
fun PersonList(personList: List<Person>, handleDeleteClick: (Person) -> Unit, handleEditClick : (Person) -> Unit){

    LazyColumn (modifier = Modifier.fillMaxSize()) {
        items(personList){
            PersonCard(person = it, onEditClick = handleEditClick, onDeleteClick = handleDeleteClick)
        }
    }
}