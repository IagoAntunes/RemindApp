package com.iagoaf.remindapp.modules.home.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iagoaf.remindapp.R
import com.iagoaf.remindapp.core.ui.theme.AppColors
import com.iagoaf.remindapp.core.ui.theme.AppTypography

@Composable
fun MenuItemModule(
    title: String,
    subtitle: String,
    @DrawableRes image: Int,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(112.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(AppColors.gray700)
            .border(
                width = 1.dp,
                color = AppColors.gray600,
                shape = RoundedCornerShape(
                    12.dp
                )
            )
            .padding(
                horizontal = 8.dp,
            ).clickable{
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .width(88.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(AppColors.gray600)
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = title,
                    style = AppTypography.subHeading,
                    color = AppColors.gray100
                )
                Text(
                    text = subtitle,
                    style = AppTypography.body,
                    color = AppColors.gray200
                )
            }
        }
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .size(16.dp),
            painter = painterResource(R.drawable.ic_arrow_forward),
            colorFilter = ColorFilter.tint(
                AppColors.gray400
            ),
            contentDescription = "",
        )
    }
}