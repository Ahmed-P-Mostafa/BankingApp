package com.polotika.auth.di

import android.content.Context
import com.polotika.auth.data.AuthRepositoryImpl
import com.polotika.auth.domain.repo.AuthRepository
import com.polotika.auth.domain.usecases.DeveloperModeCheckUseCase
import com.polotika.auth.domain.usecases.FreeRASPIntegrityCheckUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }

    @Provides
    fun provideDeveloperModeCheckUseCase(@ApplicationContext context: Context):DeveloperModeCheckUseCase{
        return DeveloperModeCheckUseCase(context);
    }

    @Provides
    fun provideIntegrityCheckUseCase(@ApplicationContext context: Context):FreeRASPIntegrityCheckUseCase{
        return FreeRASPIntegrityCheckUseCase(context)
    }
}
