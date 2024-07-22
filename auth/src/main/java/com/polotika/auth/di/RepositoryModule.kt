package com.polotika.auth.di

import com.polotika.auth.data.AuthRepositoryImpl
import com.polotika.auth.domain.repo.AuthRepository
import com.polotika.auth.domain.usecases.DeveloperModeCheckUseCase
import com.polotika.auth.domain.usecases.FreeRASPIntegrityCheckUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }

    @Provides
    fun provideDeveloperModeCheckUseCase(authRepository: AuthRepository):DeveloperModeCheckUseCase{
        return DeveloperModeCheckUseCase(authRepository = authRepository);
    }

    @Provides
    fun provideIntegrityCheckUseCase(authRepository: AuthRepository):FreeRASPIntegrityCheckUseCase{
        return FreeRASPIntegrityCheckUseCase(authRepository = authRepository)
    }
}