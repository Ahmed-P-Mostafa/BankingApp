package com.polotika.auth.domain.usecases

import com.polotika.auth.domain.repo.AuthRepository

class FreeRASPIntegrityCheckUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(): Boolean {
        return authRepository.checkAppIntegrity()
    }
}