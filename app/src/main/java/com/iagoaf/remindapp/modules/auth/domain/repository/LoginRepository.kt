package com.iagoaf.remindapp.modules.auth.domain.repository

import com.iagoaf.remindapp.modules.auth.domain.result.LoginResult

interface LoginRepository {
    suspend fun login(email: String,password: String) : LoginResult
}