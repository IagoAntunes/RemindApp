package com.iagoaf.remindapp.modules.newRecipe.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.ui.theme.AppColors
import com.iagoaf.remindapp.core.ui.theme.AppTypography
import kotlinx.coroutines.launch
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewRecipeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {

    val viewModel: NewRecipeViewModel = hiltViewModel()
    val coroutineScope = rememberCoroutineScope()

    val medicineState = remember { mutableStateOf("") }
    val timeState = remember { mutableStateOf("") }
    val recurrenceState = remember { mutableStateOf("") }

    val recurrenceList = listOf<String>(
        "Diariamente",
        "Semanalmente",
        "Mensalmente",
    )
    val recurrenceDropDownExpanded = remember { mutableStateOf(false) }

    val isLoading = remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }

    val uiState = viewModel.uiState.value

    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )
    val showTimePicker = remember { mutableStateOf(false) }

    LaunchedEffect(uiState) {
        when (uiState) {
            is NewRecipeState.Loading -> {
                isLoading.value = true
            }

            is NewRecipeState.Success -> {
                isLoading.value = false
                medicineState.value = ""
                timeState.value = ""
                recurrenceState.value = ""
                snackbarHostState.showSnackbar(
                    message = "Receita adicionada com sucesso",
                )
            }

            is NewRecipeState.Error -> {
                isLoading.value = false
            }

            is NewRecipeState.Idle -> {
                isLoading.value = false
            }
        }
    }



    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        contentColor = AppColors.gray800,
        content = { paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 24.dp,
                        vertical = 32.dp
                    )
                    .padding(paddingValues),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = "Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    "Nova receita",
                    style = AppTypography.heading,
                    color = AppColors.redBase,
                )
                Text(
                    "Adicione a sua prescrição médica para receber lembretes de quando tomar seu medicamento",
                    style = AppTypography.body,
                    color = AppColors.gray200,
                )
                Spacer(Modifier.height(32.dp))
                Text(
                    text = "Remédio",
                    style = AppTypography.label,
                    color = AppColors.gray100
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = medicineState.value,
                    onValueChange = { medicineState.value = it },
                    enabled = !isLoading.value,
                    placeholder = {
                        Text(
                            text = "Nome do medicamento",
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
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Horário",
                    style = AppTypography.label,
                    color = AppColors.gray100
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(AppColors.gray800)
                        .border(
                            width = 1.dp,
                            color = AppColors.gray400,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(16.dp)
                        .clickable {
                            showTimePicker.value = true
                        }
                ){
                    Text(
                        text = timeState.value,
                        style = AppTypography.input,
                        color = AppColors.gray200
                    )
                }
                if (showTimePicker.value) {
                    AlertDialog(
                        onDismissRequest = { showTimePicker.value = false },
                        confirmButton = {
                            TextButton(onClick = {
                                timeState.value =
                                    "${timePickerState.hour}:${timePickerState.minute}"
                                showTimePicker.value = false
                            }) {
                                Text("OK")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showTimePicker.value = false }) {
                                Text("Cancel")
                            }
                        },
                        text = {
                            TimePicker(state = timePickerState)
                        }
                    )
                }
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Recorrência",
                    style = AppTypography.label,
                    color = AppColors.gray100
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(AppColors.gray800)
                        .border(
                            width = 1.dp,
                            color = AppColors.gray400,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                if (isLoading.value) {
                                    return@clickable
                                }
                                recurrenceDropDownExpanded.value = !recurrenceDropDownExpanded.value
                            }
                    ) {
                        Text(
                            text = recurrenceState.value,
                            style = AppTypography.input,
                            color = AppColors.gray200
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_drop_down),
                            contentDescription = "DropDown Icon",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    DropdownMenu(
                        expanded = recurrenceDropDownExpanded.value,
                        onDismissRequest = {
                            recurrenceDropDownExpanded.value = false
                        },
                        content = {
                            recurrenceList.forEachIndexed { index, username ->
                                DropdownMenuItem(
                                    text = {
                                        Text(text = username)
                                    },
                                    onClick = {
                                        recurrenceState.value = username
                                        recurrenceDropDownExpanded.value = false
                                    }
                                )
                            }
                        }
                    )
                }
                Spacer(Modifier.weight(1f))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.redBase,
                    ),
                    onClick = {
                        if (medicineState.value.isNotEmpty()
                            && timeState.value.isNotEmpty()
                            && recurrenceState.value.isNotEmpty()
                        ) {
                            coroutineScope.launch {
                                viewModel.addRecipe(
                                    medicineState.value,
                                    timeState.value,
                                    recurrenceState.value
                                )
                            }
                        } else {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Preencha os campos",
                                )
                            }
                        }
                    },
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(
                                vertical = 4.dp,
                            )
                        ) {
                            if (isLoading.value) {
                                CircularProgressIndicator()
                            } else {
                                Image(
                                    painterResource(R.drawable.ic_add),
                                    contentDescription = "Adicionar",
                                    colorFilter = ColorFilter.tint(Color.White),
                                )
                                Text(
                                    "Adicionar",
                                    style = AppTypography.subHeading,
                                    color = AppColors.gray800,
                                )
                            }

                        }
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewNewRecipeScreen() {
    NewRecipeScreen(rememberNavController())
}