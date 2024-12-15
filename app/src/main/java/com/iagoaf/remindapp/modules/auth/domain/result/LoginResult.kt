package com.iagoaf.remindapp.modules.auth.domain.result

sealed class LoginResult{
    data class Success(val token: String) : LoginResult()
    data class Error(val message: String) : LoginResult()
}