package com.example.client.presentation.pages.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.presentation.pages.home.data.HomeScreenData
import com.example.client.presentation.pages.home.data.HomeScreenItem
import com.example.client.ui.theme.ClientTheme

@Composable
fun SubContentHolder(homeScreenItem: HomeScreenItem, onEvent: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .aspectRatio(1f),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        shape = RoundedCornerShape(32.dp),
        onClick = onEvent
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally),
                imageVector = homeScreenItem.iconNormal,
                contentDescription = homeScreenItem.title
            )
            Text(
                text = homeScreenItem.title,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSubContentHolder() {
    ClientTheme() {
        SubContentHolder(HomeScreenData.homePageItem[0], onEvent = {}, modifier = Modifier)
    }
}