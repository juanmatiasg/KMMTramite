package com.example.kmmtramites.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ViewResponse(
    var data:List<ViewData>,
    var isSuccess:Boolean,
    var message:String
)
