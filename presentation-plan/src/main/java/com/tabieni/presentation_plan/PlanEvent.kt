package com.tabieni.presentation_plan

import java.time.DayOfWeek

sealed class PlanEvent {
    data class DayOfWeek(val dayOfWeek: java.time.DayOfWeek):PlanEvent()
}