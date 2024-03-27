package com.tabieni.presentation_plan.model

import java.util.UUID

data class Spinner(
    val id : String = UUID.randomUUID().toString(),
    val spinnerItemText:String
)
