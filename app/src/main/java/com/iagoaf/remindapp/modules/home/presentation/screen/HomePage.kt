package com.iagoaf.remindapp.modules.home.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.iagoaf.remindapp.AppScreens
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.ui.theme.AppColors
import com.iagoaf.remindapp.core.ui.theme.AppTypography
import com.iagoaf.remindapp.modules.home.presentation.components.MenuItemModule

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = AppColors.gray600,
        content = { paddingValues ->
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(top = 24.dp)
            ) {
                // Conteúdo principal da tela
                Column {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(
                                horizontal = 24.dp,
                                vertical = 24.dp,
                            ),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        // Seção do perfil
                        Box(
                            modifier = Modifier
                                .height(64.dp)
                                .width(64.dp)
                                .border(
                                    width = 1.5.dp,
                                    color = AppColors.blueBase,
                                    shape = CircleShape
                                )
                        ) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                painter = painterResource(R.drawable.ic_person),
                                contentDescription = ""
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Boas Vindas",
                            style = AppTypography.subHeading.copy(
                                fontWeight = FontWeight.Normal,
                            ),
                            color = AppColors.gray200
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Iago Ferreira",
                            style = AppTypography.heading,
                            color = AppColors.gray100
                        )
                    }

                    // Modulos
                    Column(
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
                                horizontal = 24.dp,
                                vertical = 24.dp,
                            )
                    ) {
                        MenuItemModule(
                            title = "Minhas receitas",
                            subtitle = "Acompanhe os medicamentos e gerencie lembretes",
                            image = R.drawable.img_paper,
                            onClick = {
                                navController.navigate(AppScreens.MyRecipes.route)
                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        MenuItemModule(
                            title = "Nova receita",
                            subtitle = "Cadastre novos lembretes de receitas",
                            image = R.drawable.img_pills,
                            onClick = {
                                navController.navigate(AppScreens.NewRecipe.route)
                            }
                        )
                    }
                }

                // Ícone de logout no canto superior direito
                Image(
                    painter = painterResource(R.drawable.ic_logout),
                    colorFilter = ColorFilter.tint(AppColors.redBase),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .size(24.dp)
                        .clickable{
                            navController.navigate(AppScreens.Login.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                }
                            }
                        }
                )
            }
        }
    )
}


@Preview
@Composable
private fun PreviewHomePage() {
    HomeScreen(rememberNavController())
}