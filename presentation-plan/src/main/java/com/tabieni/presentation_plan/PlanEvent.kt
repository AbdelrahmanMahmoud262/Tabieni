package com.tabieni.presentation_plan

import com.tabieni.domain.entity.Plan
import java.time.DayOfWeek

sealed class PlanEvent {
    data class DayOfWeek(val dayOfWeek: java.time.DayOfWeek):PlanEvent()
    data class CreatePlan(val plan: Plan): PlanEvent()
}