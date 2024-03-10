package com.tabieni.domain.usecase

import com.tabieni.domain.repository.MemorizeRepository
import javax.inject.Inject

class TestUseCase @Inject constructor(
    private val memorizeRepository: MemorizeRepository
) {
    fun getMemorize() = memorizeRepository.getMemorize()
}