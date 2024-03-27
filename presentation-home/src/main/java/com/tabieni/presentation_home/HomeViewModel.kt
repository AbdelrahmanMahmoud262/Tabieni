package com.tabieni.presentation_home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tabieni.domain.entity.Result
import com.tabieni.domain.usecase.GetLastMemorizedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLastMemorizedUseCase: GetLastMemorizedUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getLastMemorized()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {

            else -> {}
        }
    }

    private fun getLastMemorized() = viewModelScope.launch {
        getLastMemorizedUseCase.invoke()
            .let { response ->
                response.result.let { result ->
                    when (result) {
                        is Result.Error -> _state.value =
                            _state.value.copy(error = result.exception.localizedMessage)

                        is Result.Success -> _state.value =
                            _state.value.copy(lastMemorized = result.data)
                    }
                }
            }
    }


}