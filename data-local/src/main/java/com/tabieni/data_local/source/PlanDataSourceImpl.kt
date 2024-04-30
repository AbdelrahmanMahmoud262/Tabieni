package com.tabieni.data_local.source

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.tabieni.data_repository.source.PlanDataSource
import com.tabieni.domain.entity.Plan
import com.tabieni.domain.entity.PlanType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.sql.Date
import javax.inject.Inject

internal val PLAN_TYPE = stringPreferencesKey("planType")
internal val PLAN_STARTING_DATE = stringPreferencesKey("planStartingDate")
internal val FREQUENCY = stringPreferencesKey("frequency")
internal val LAST_WORKED = stringPreferencesKey("lastWorked")

class PlanDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) :PlanDataSource{

    override suspend fun setPlan(plan: Plan) {
        dataStore.edit {
            it[PLAN_TYPE] = plan.planType.toString()
            it[PLAN_STARTING_DATE] = plan.startingDate.toString()
            it[FREQUENCY] = plan.frequency.toString()
            it[LAST_WORKED] = plan.lastWorked.toString()
        }
    }

    override  fun getPlan(): Flow<Plan> {
        return dataStore.data.map {
            var planType:PlanType? = null
            for(type in PlanType.entries){ if(it[PLAN_TYPE] == type.toString()) planType = type}
            Plan(
                planType,
                Date.valueOf(it[PLAN_STARTING_DATE]),
                it[FREQUENCY]?.toInt(),
                Date.valueOf(it[LAST_WORKED])
            )
        }
    }
}