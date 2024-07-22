package com.polotika.auth.domain.repo

import com.polotika.auth.domain.Result
import com.polotika.auth.domain.entity.Account

interface AuthRepository {
    fun login(username: String, password: String): Result<Account>
    fun register(username: String, password: String, cardNumber:String, uid:String): Result<Boolean>

    fun logout():Boolean
    fun isLoggedIn():Boolean

    fun isDeveloperModeOn():Boolean

    fun checkAppIntegrity():Boolean

}