package com.iagoaf.remindapp.modules.auth.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.ui.theme.AppColors
import com.iagoaf.remindapp.core.ui.theme.AppTypography
import kotlinx.coroutines.launch
import androidx.hilt.navigation.compose.hiltViewModel
import com.iagoaf.remindapp.AppScreens

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val loginViewModel: LoginViewModel = hiltViewModel()

    //FormState
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val obscurePassword = remember { mutableStateOf(true) }

    //SnackBar
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val loginState = loginViewModel.state.collectAsState().value
    if (loginState is LoginState.Success) {
        LaunchedEffect(Unit) {
            navController.navigate(AppScreens.Splash.route)
        }
    }

    Scaffold(
        snackbarHost =  {
            SnackbarHost(hostState = snackbarHostState)
        },
        content = {paddingValues ->
            Column(
                modifier
                    .fillMaxSize()
                    .background(AppColors.redBase)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.remind_logo),
                        contentDescription = "Remind Logo",
                        modifier = Modifier
                            .height(48.dp)
                            .width(204.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                        .background(AppColors.gray800)
                ){
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(
                            horizontal = 24.dp,
                            vertical = 28.dp,
                        )
                    ) {
                        Text(
                            text = "Entre para acessar suas receitas",
                            style = AppTypography.subHeading,
                            color = AppColors.gray100
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(
                            text = "Email",
                            style = AppTypography.label,
                            color = AppColors.gray100
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value =emailState.value,
                            onValueChange = { emailState.value = it },
                            placeholder = {
                                Text(
                                    text = "Digite seu email",
                                    style = AppTypography.input,
                                    color = AppColors.gray200
                                )
                            },
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = AppColors.gray800,
                                focusedContainerColor = AppColors.gray800,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                width = 1.dp,
                                color = AppColors.gray400,
                                shape = RoundedCornerShape(8.dp)
                            )
                        )
                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = "Senha",
                            style = AppTypography.label,
                            color = AppColors.gray100
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value =passwordState.value,
                            placeholder = {
                                Text(
                                    text = "Digite sua senha",
                                    style = AppTypography.input,
                                    color = AppColors.gray200
                                )
                            },
                            onValueChange = { passwordState.value = it },
                            visualTransformation = if(obscurePassword.value) PasswordVisualTransformation() else VisualTransformation.None,
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = AppColors.gray800,
                                focusedContainerColor = AppColors.gray800,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                focusedTextColor = AppColors.gray200,
                                unfocusedTextColor = AppColors.gray200,
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        obscurePassword.value = !obscurePassword.value
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(
                                            id = if(obscurePassword.value) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off
                                        ),
                                        contentDescription = "Show password",
                                        colorFilter = ColorFilter.tint(AppColors.blueBase)
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    color = AppColors.gray400,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        )
                        Spacer(Modifier.height(32.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AppColors.redBase,
                            ),
                            onClick = {
                                if(emailState.value.isEmpty() || passwordState.value.isEmpty()) {
                                    scope.launch {
                                        snackbarHostState.showSnackbar("Snackbar")
                                    }
                                } else {
                                    scope.launch {
                                        loginViewModel.login(emailState.value, passwordState.value)
                                    }
                                }
                            },
                            content = {
                                Text(
                                    text = "Entrar",
                                    style = AppTypography.subHeading,
                                    color = AppColors.gray800
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(
        navController = rememberNavController()
    )
}