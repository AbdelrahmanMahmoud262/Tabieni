package com.tabieni.domain.entity

data class Memorize(
    val id: Int,
    val part: Int,
    val fromSurah: Int,
    val toSurah: Int,
    val fromAyah: Int,
    val toAyah: Int,
    val done: Boolean?,
)
