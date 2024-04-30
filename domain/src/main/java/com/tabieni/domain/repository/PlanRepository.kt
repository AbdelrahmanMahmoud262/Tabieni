package com.tabieni.domain.repository

import com.tabieni.domain.entity.Plan
import kotlinx.coroutines.flow.Flow

interface PlanRepository {

    suspend fun setPlan(plan:Plan)

    fun getPlan(): Flow<Plan>

}