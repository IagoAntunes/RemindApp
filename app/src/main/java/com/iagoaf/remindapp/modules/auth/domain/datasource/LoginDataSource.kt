package com.iagoaf.remindapp.modules.auth.domain.datasource

import com.iagoaf.remindapp.modules.auth.domain.result.LoginResult

interface LoginDataSource {
    suspend fun login(email: String, password: String) : LoginResult
}