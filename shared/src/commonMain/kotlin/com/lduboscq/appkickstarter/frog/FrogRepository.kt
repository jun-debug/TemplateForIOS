package com.lduboscq.appkickstarter

import androidx.compose.runtime.MutableState

interface FrogRepository {
    suspend fun getFrog(frogName : String): FrogData?
    suspend fun addFrog(frogData : FrogData): FrogData?
    suspend fun updateFrog(frogName : String): FrogData?
    suspend fun deleteFrog(frogName : String): FrogData?
}