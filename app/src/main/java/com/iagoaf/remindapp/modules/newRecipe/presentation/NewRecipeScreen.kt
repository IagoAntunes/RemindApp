package com.iagoaf.remindapp.modules.newRecipe.presentation

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.ui.theme.AppColors
import com.iagoaf.remindapp.core.ui.theme.AppTypography

@Composable
fun NewRecipeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val medicineState = remember { mutableStateOf("") }
    val timeState = remember { mutableStateOf("") }
    val recurrenceState = remember { mutableStateOf("") }

    Scaffold(
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
                    modifier = Modifier.clickable{
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
                TextField(
                    value = timeState.value,
                    onValueChange = { timeState.value = it },
                    placeholder = {
                        Text(
                            text = "00:00",
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
                    text = "Recorrência",
                    style = AppTypography.label,
                    color = AppColors.gray100
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = recurrenceState.value,
                    onValueChange = { recurrenceState.value = it },
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
                Spacer(Modifier.weight(1f))
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.redBase,
                    ),
                    onClick = {

                    },
                    content = {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(
                                vertical = 4.dp,
                            )
                        ) {
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
                )
            }
        }
    )
}

@Preview
@Composable
private fun PreviewNewRecipeScreen() {
    NewRecipeScreen(rememberNavController())
}