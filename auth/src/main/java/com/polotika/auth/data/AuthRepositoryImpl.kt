package com.polotika.auth.data

import com.polotika.auth.domain.Result
import com.polotika.auth.domain.entity.Account
import com.polotika.auth.domain.repo.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override fun login(username: String, password: String): Result<Account> {
        TODO("Not yet implemented")
    }

    override fun register(
        username: String,
        password: String,
        cardNumber: String,
        uid: String
    ): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isLoggedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isDeveloperModeOn(): Boolean {
        TODO("Not yet implemented")
    }

    override fun checkAppIntegrity(): Boolean {
        TODO("Not yet implemented")
    }
}