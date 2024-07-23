package com.polotika.auth.presentation.splash

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.polotika.auth.domain.usecases.DeveloperModeCheckUseCase
import com.polotika.auth.domain.usecases.FreeRASPIntegrityCheckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @ApplicationContext private val application: Context
) : ViewModel() {

    private val freeRASPIntegrityCheckUseCase = FreeRASPIntegrityCheckUseCase(application)
    private val developerModeCheckUseCase = DeveloperModeCheckUseCase(application)

    private val _isIntegrityValid = MutableLiveData<Boolean>()
    val isIntegrityValid: LiveData<Boolean> = _isIntegrityValid

    private val _isDeveloperModeEnabled = MutableLiveData<Boolean>()
    val isDeveloperModeEnabled: LiveData<Boolean> = _isDeveloperModeEnabled

    suspend fun performChecks() {
       // _isIntegrityValid.value = freeRASPIntegrityCheckUseCase.execute()
        _isDeveloperModeEnabled.value = developerModeCheckUseCase.execute()
    }

}