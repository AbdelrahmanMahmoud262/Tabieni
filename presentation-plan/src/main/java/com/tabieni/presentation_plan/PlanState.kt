package com.tabieni.presentation_plan

import com.tabieni.domain.entity.Collection
import java.time.DayOfWeek

data class PlanState(
    val planName:String = "",
    val daysLeft:Int = 0,
    val planList:List<Collection> = emptyList(),
    val selectedDayOfWeek: DayOfWeek = DayOfWeek.SUNDAY,
)
