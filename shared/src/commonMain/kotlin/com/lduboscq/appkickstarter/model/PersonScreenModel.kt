package com.lduboscq.appkickstarter.model

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.launch

class PersonScreenModel(private val repository: PersonRepository)
    : StateScreenModel<PersonScreenModel.State>(State.Init){
    sealed class State {
        object Init : State()
        object Loading : State()
        sealed class Result: State(){
            class SingleResult(val person: Person?) : Result()
            class MultiResults(val personList: List<Person>) : Result()
        }
        object Complete: State()
        class Error(val errorMsg: String?) : State()
    }


    fun getPerson(name: String){
        coroutineScope.launch {
            try {
                mutableState.value = State.Loading
                mutableState.value = State.Result.SingleResult(repository.getPerson(name))
            }
            catch (e : Exception){
                mutableState.value = State.Error(e.message)
            }
        }
    }

    init {
        getPersons()
    }

    fun getPersons(){
        coroutineScope.launch {
            try {
                mutableState.value = State.Loading
                mutableState.value = State.Result.MultiResults(repository.getPersons())
            }
            catch (e : Exception){
                mutableState.value = State.Error(e.message)
            }
        }
    }

    fun addPerson(person: Person){
        coroutineScope.launch {
            try {
                mutableState.value = State.Loading
                mutableState.value = State.Result.SingleResult(repository.addPerson(person))
            }
            catch (e : Exception){
                mutableState.value = State.Error(e.message)
            }
        }
    }

    fun updatePerson(person: Person){
        coroutineScope.launch {
            try {
                mutableState.value = State.Loading
                mutableState.value = State.Result.SingleResult(repository.updatePerson(person))
            }
            catch (e : Exception){
                mutableState.value = State.Error(e.message)
            }
        }
    }

    fun deletePerson(id: String){
        coroutineScope.launch {
            try {
                mutableState.value = State.Loading
                repository.deletePerson(id)
                mutableState.value = State.Complete
            }
            catch (e : Exception){
                mutableState.value = State.Error(e.message)
            }
        }
    }
}