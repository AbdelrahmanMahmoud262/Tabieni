package com.tabieni.domain.entity

data class Revision(
    val id: Int,
    val part: Int,
    val fromSurah: Int,
    val toSorah: Int,
    val fromAyah: Int,
    val toAyah: Int,
    val done: Boolean?,
)
