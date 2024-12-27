package com.iagoaf.remindapp.modules.myRecipes.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.domain.models.RecipeModel
import com.iagoaf.remindapp.core.ui.theme.AppColors
import com.iagoaf.remindapp.core.ui.theme.AppTypography
import com.iagoaf.remindapp.modules.myRecipes.presentation.components.ItemMedicineRecipe
import kotlinx.coroutines.launch

@Composable
fun MyRecipesScreen(
    navController: NavController,
) {

    val viewModel = hiltViewModel<MyRecipesViewModel>()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.getAll()
    }


    var list = emptyList<RecipeModel>()

    when (viewModel.uiState.value) {
        is MyRecipesState.Success -> {
            list = (viewModel.uiState.value as MyRecipesState.Success).recipes
        }

        is MyRecipesState.Error -> {}
        is MyRecipesState.Idle -> {}
        is MyRecipesState.Loading -> {}
    }


    Scaffold(
        containerColor = AppColors.gray600,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.25f)
                            .heightIn(max = 224.dp)
                            .padding(
                                horizontal = 24.dp,
                                vertical = 16.dp,
                            )
                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Image(
                                    painterResource(R.drawable.ic_arrow_back),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .clickable {
                                            navController.popBackStack()
                                        }
                                )
                                Box(
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(40.dp)
                                        .clip(
                                            shape = CircleShape
                                        )
                                        .background(AppColors.blueBase)
                                ) {
                                    Image(
                                        painterResource(R.drawable.ic_healthy),
                                        contentDescription = "Add",
                                        colorFilter = ColorFilter.tint(Color.White),
                                        modifier = Modifier
                                            .align(Alignment.Center)

                                    )
                                }

                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                "Minhas receitas",
                                style = AppTypography.heading,
                                color = AppColors.blueBase,
                            )
                            Text(
                                "Acompanhe seus medicamentos cadastrados e gerencie lembretes",
                                style = AppTypography.body,
                                color = AppColors.gray200,
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 24.dp,
                                    topStart = 24.dp,
                                )
                            )
                            .background(AppColors.gray800)
                            .padding(
                                top = 32.dp,
                                start = 24.dp,
                                end = 24.dp,
                            )
                    ) {
                        LazyColumn(
                            contentPadding = paddingValues,
                        ) {
                            items(list) { item ->
                                ItemMedicineRecipe(
                                    title = item.name,
                                    time = item.time,
                                    repeatTime = item.recurrence,
                                    onDelete = {
                                        coroutineScope.launch() {
                                            viewModel.delete(item)
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun PreviewMyRecipesScreen() {
    MyRecipesScreen(rememberNavController())
}