package com.tabieni.domain.entity

data class RevisionWithSurah(
    val id: Int = 0,
    val part: Int = 0,
    val fromSurah: Surah = Surah(),
    val toSurah: Surah = Surah(),
    val fromAyah: Int = 0,
    val toAyah: Int = 0,
    val done: Boolean? = false,
)
