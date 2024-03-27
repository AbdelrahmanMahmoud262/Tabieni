package com.tabieni.domain.entity

data class Connection(
    val id: Int,
    val part: Int,
     val fromSorah: Int,
     val toSorah: Int,
     val fromAyah: Int,
     val toAyah: Int,
     val done: Boolean?
)