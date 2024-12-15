package com.iagoaf.remindapp.modules.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagoaf.remindapp.modules.auth.domain.repository.LoginRepository
import com.iagoaf.remindapp.modules.auth.domain.result.LoginResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
) : ViewModel() {
    private val _state = MutableStateFlow<LoginState>(LoginState.Idle)
    val state: StateFlow<LoginState> get() = _state

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _state.value = LoginState.Loading
            val result = loginRepository.login(email, password)
            _state.value = if (result is LoginResult.Success) {
                LoginState.Success
            } else {
                LoginState.Error
            }
        }
    }

}