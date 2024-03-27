package com.tabieni.domain.entity

data class Surah(
    val id: Int,
    val arabicName: String,
    val englishName: String,
    val arabicType: String,
    val englishType: String,
    val ayahCount: Int,
    val meaningEnglish: String,
    val page: Int,
)