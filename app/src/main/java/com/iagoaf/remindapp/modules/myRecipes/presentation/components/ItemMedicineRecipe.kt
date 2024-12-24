package com.iagoaf.remindapp.modules.myRecipes.presentation.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.ui.theme.AppColors
import com.iagoaf.remindapp.core.ui.theme.AppTypography


@Composable
fun ItemMedicineRecipe(
    title: String,
    time: String,
    repeatTime: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(12)
            )
            .background(color = AppColors.gray700)
            .border(
                width = 1.dp,
                color = AppColors.gray600,
                shape = RoundedCornerShape(
                    12.dp
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 14.dp,
                    vertical = 14.dp,
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    title,
                    style = AppTypography.subHeading,
                    color = AppColors.gray200,
                )
                Image(
                    painter = painterResource(R.drawable.ic_delete),
                    contentDescription = "Delete",
                    colorFilter = ColorFilter.tint(
                        AppColors.redBase
                    ),
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(24)
                        )
                        .background(color = AppColors.gray500)
                        .padding(
                            horizontal = 8.dp,
                            vertical = 4.dp,
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_time),
                            contentDescription = "Time",
                            colorFilter = ColorFilter.tint(
                                AppColors.gray300
                            ),
                            modifier = Modifier.size(
                                14.dp,
                                14.dp,
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            time,
                            style = AppTypography.tag,
                            color = AppColors.gray100,
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(24)
                        )
                        .background(color = AppColors.gray500)
                        .padding(
                            horizontal = 8.dp,
                            vertical = 4.dp,
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_repeat),
                            contentDescription = "Repeat",
                            colorFilter = ColorFilter.tint(
                                AppColors.gray300
                            ),
                            modifier = Modifier.size(
                                14.dp,
                                14.dp,
                            )

                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            repeatTime,
                            style = AppTypography.tag,
                            color = AppColors.gray100,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewItemMedicineRecipe() {
    ItemMedicineRecipe(
        title = "Dipirona",
        time = "08:00",
        repeatTime = "A cada 12 horas"
    )
}