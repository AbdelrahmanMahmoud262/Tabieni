package com.tabieni.domain.entity

import java.util.Date


data class Plan(
    val planType: PlanType? = null,
    val startingDate: Date? = null,
    val frequency: Int? = null, // Days per week
    val lastWorked: Date? = null
)

enum class PlanType{
    HALF_HIZB,
    QUARTER_HIZB,
    JUZ
}
