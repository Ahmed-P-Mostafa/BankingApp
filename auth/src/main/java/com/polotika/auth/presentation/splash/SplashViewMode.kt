package com.polotika.auth.presentation.splash

import android.view.View
import androidx.lifecycle.ViewModel
import com.polotika.auth.domain.usecases.DeveloperModeCheckUseCase
import com.polotika.auth.domain.usecases.FreeRASPIntegrityCheckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewMode @Inject constructor(
    private val developerModeCheckUseCase: DeveloperModeCheckUseCase,
    private val integrityCheckUseCase: FreeRASPIntegrityCheckUseCase
) : ViewModel() {

}