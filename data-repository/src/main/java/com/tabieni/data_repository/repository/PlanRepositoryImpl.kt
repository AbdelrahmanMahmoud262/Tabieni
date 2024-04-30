package com.tabieni.data_repository.repository

import com.tabieni.data_repository.source.PlanDataSource
import com.tabieni.domain.entity.Plan
import com.tabieni.domain.repository.PlanRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlanRepositoryImpl @Inject  constructor(
    private val planDataSource: PlanDataSource
):PlanRepository{

    override suspend fun setPlan(plan: Plan) = planDataSource.setPlan(plan)

    override fun getPlan(): Flow<Plan> = planDataSource.getPlan()

}