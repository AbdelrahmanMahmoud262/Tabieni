package com.tabieni.presentation_home

import com.tabieni.domain.entity.MemorizeWithSurah

data class HomeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val name: String = "",
    val lastMemorized: MemorizeWithSurah? = null,
    val todayWork:String = ""
)
