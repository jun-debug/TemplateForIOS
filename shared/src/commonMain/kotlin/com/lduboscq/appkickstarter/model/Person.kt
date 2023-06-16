package com.lduboscq.appkickstarter.model

import com.seiko.imageloader.component.fetcher.KtorUrlFetcher

data class Person(
    var id: String ,
    var name: String,
    val role: String,
    val imageUrl : String = ""
)
