package com.iagoaf.remindapp.modules.auth.data.datasource

import com.iagoaf.remindapp.modules.auth.domain.datasource.LoginDataSource
import com.iagoaf.remindapp.modules.auth.domain.result.LoginResult

class LoginDataSourceImpl : LoginDataSource {
    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        return LoginResult.Success("Login success")
    }
}