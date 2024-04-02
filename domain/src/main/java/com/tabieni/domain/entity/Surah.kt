package com.tabieni.domain.entity

data class Surah(
    val id: Int = 0,
    val arabicName: String = "",
    val englishName: String = "",
    val arabicType: String = "",
    val englishType: String = "",
    val ayahCount: Int = 0,
    val meaningEnglish: String = "",
    val page: Int = 0,
)