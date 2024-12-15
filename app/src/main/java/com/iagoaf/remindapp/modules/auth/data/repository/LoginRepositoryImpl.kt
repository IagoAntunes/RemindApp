package com.iagoaf.remindapp.modules.auth.data.repository

import com.iagoaf.remindapp.modules.auth.domain.datasource.LoginDataSource
import com.iagoaf.remindapp.modules.auth.domain.repository.LoginRepository
import com.iagoaf.remindapp.modules.auth.domain.result.LoginResult

class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource
) : LoginRepository {
    override suspend fun login(
        email: String,
        password: String
    ): LoginResult {
        return loginDataSource.login(
            email = email,
            password = password
        )
    }
}