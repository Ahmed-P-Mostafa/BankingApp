package com.polotika.auth.domain.usecases

import com.polotika.auth.domain.repo.AuthRepository

class DeveloperModeCheckUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(): Boolean {
        return authRepository.isDeveloperModeOn()
    }
}