package com.tabieni.presentation_plan.utils

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

fun DayOfWeek.dayOfMonth(dateInWeek: LocalDate = LocalDate.now()): Int {
    val firstDateOfWeek = dateInWeek.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
    val dateOfDayOfWeek = firstDateOfWeek.with(TemporalAdjusters.nextOrSame(this))
    return dateOfDayOfWeek.dayOfMonth
}
