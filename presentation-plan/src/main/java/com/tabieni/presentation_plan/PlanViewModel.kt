package com.tabieni.presentation_plan

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tabieni.domain.entity.Collection
import com.tabieni.domain.usecase.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanViewModel @Inject constructor(
    private val getCollectionsUseCase: GetCollectionsUseCase
):ViewModel(){

    private val _state = mutableStateOf(PlanState())
    val state:State<PlanState> = _state

    init {
        getCollection()
    }

    private fun getCollection(){
        viewModelScope.launch {
            getCollectionsUseCase.invoke().collect{
                _state.value = _state.value.copy(planList = it)
            }
        }
    }
}