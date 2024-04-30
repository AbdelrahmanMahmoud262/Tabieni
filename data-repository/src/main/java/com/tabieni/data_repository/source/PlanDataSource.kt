package com.tabieni.data_repository.source

import com.tabieni.domain.entity.Plan
import kotlinx.coroutines.flow.Flow

interface PlanDataSource {


    suspend fun setPlan(plan: Plan)

    fun getPlan(): Flow<Plan>

}