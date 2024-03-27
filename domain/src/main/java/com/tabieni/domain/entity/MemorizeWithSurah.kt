package com.tabieni.domain.entity


data class MemorizeWithSurah(
    val id: Int,
    val part: Int,
    val fromSurah: Surah,
    val toSurah: Surah,
    val fromAyah: Int,
    val toAyah: Int,
    val done: Boolean?,
)