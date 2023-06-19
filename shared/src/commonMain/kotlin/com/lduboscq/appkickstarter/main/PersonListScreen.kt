package com.lduboscq.appkickstarter.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.lduboscq.appkickstarter.model.Person
import com.lduboscq.appkickstarter.model.PersonScreenModel
import com.lduboscq.appkickstarter.realm.PersonRepositoryRealmLocal

internal class PersonListScreen : Screen{
    @Composable
    override fun Content() {
        var personScreenModel = rememberScreenModel { PersonScreenModel(PersonRepositoryRealmLocal()) }
        val state by personScreenModel.state.collectAsState()

        var personList = remember { mutableStateListOf<Person>() }

        val navigator = LocalNavigator.currentOrThrow
        var isAddingMode by remember { mutableStateOf(false) }
        var isLoadingComplete by remember { mutableStateOf(false) }
        var message by remember { mutableStateOf("") }

        var currentPerson : Person = Person()


        Scaffold (
            topBar = {
                MyTopBar( title = "Person List"){
                    navigator.pop()
                }
            },
            bottomBar = {
                BottomAppBar (modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Copyright (c) 2023 Jun Liang",
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        textAlign = TextAlign.Center
                    )
                    IconButton(
                        onClick = {
                            isAddingMode = true
                            currentPerson = Person()
                        },
                        enabled = !isAddingMode
                    ) {
                        Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add person")
                    }
                }
            }
        ) {
            Column(
                modifier = Modifier.padding(20.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (isAddingMode) {
                    AddPersonContent(
                        person = currentPerson,
                        onSavePerson = {
                            isLoadingComplete = false
                            if (it.id == null) {
                                personScreenModel.addPerson(it)
                            }
                            else {
                                personScreenModel.updatePerson(it)
                            }
                        },
                        onDone = { isAddingMode = false })
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    message = when (state) {
                        is PersonScreenModel.State.Result -> {
                            if (state is PersonScreenModel.State.Result.SingleResult) {
                                if ((state as PersonScreenModel.State.Result.SingleResult).person != null) {
                                    currentPerson = (state as PersonScreenModel.State.Result.SingleResult).person!!
                                    val idx = personList.indexOfFirst { person: Person -> person.id == currentPerson.id }
                                    if (idx == -1){
                                        personList.add(currentPerson)
                                    }
                                    else{
                                         personList[idx] = currentPerson
                                    }
                                }
                            } else if (state is PersonScreenModel.State.Result.MultiResults) {
                                personList.clear()
                                personList.addAll((state as PersonScreenModel.State.Result.MultiResults).personList)
                            }

                            isLoadingComplete = true
                            "Getting result..."
                        }

                        is PersonScreenModel.State.Error -> {
                            (state as PersonScreenModel.State.Error).errorMsg.toString()
                        }

                        is PersonScreenModel.State.Complete -> {
                            isLoadingComplete = true
                            "Loading complete."
                        }

                        else -> {
                            "Loading data..."
                        }
                    }
                    if (!isLoadingComplete) {
                        Text("$message")
                    }
                    PersonList(
                        personList = personList,
                        handlePersonDetailClick = {
                                                  navigator.push(PersonDetailScreen(it))
                        },
                        handleDeleteClick = {
                            isLoadingComplete = false
                            it.id?.let { id -> personScreenModel.deletePerson(id) }
                            personList.remove(it)
                        },
                        handleEditClick = {
                            currentPerson = it
                            isAddingMode = true
                        }
                    )
                }
            }
        }
    }

}