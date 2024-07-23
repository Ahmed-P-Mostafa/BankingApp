package com.polotika.auth.domain.usecases

import android.content.Context
import android.provider.Settings

class DeveloperModeCheckUseCase(private val context: Context) {
    fun execute(): Boolean {
        return Settings.Secure.getInt(
            context.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0
        ) != 0
    }
}