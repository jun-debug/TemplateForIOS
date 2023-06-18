package com.lduboscq.appkickstarter.model

import com.seiko.imageloader.component.fetcher.KtorUrlFetcher

data class Person(
    var id: String ? = null,
    var name: String = "",
    var role: String = "",
    var imageUrl : String = ""
)
