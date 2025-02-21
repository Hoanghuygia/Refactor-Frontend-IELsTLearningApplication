package com.example.client.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.domain.model.Test

@Composable
fun TestCard(modifier: Modifier = Modifier, test: Test) {
    Box(modifier = modifier.fillMaxWidth().clickable{}) { // only the most above use the modifier that pass in
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize().padding(start = 12.dp),
//                contentAlignment = Alignment.Center
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = when (test.progress) {
                            "Done" -> Icons.Filled.CheckCircle
                            "InProgress" -> Icons.Filled.Update
                            else -> Icons.Filled.Bolt
                        },
                        contentDescription = when (test.progress) {
                            "Done" -> "Archived"
                            "InProgress" -> "InProgress"
                            else -> "Challenge"
                        },
                        tint = when(test.progress){
                            "Done" -> Color.Green.copy(alpha = 0.6f)
                            "InProgress" -> Color.Blue.copy(alpha = 0.6f)
                            else -> Color.LightGray
                        },
                        modifier = Modifier.size(32.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(start = 16.dp)
                    ) {
                        Text(
                            text = test.book,
                            fontSize = 19.sp,
//                        fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = test.name,
                            fontSize = 16.sp
                        )
                    }
                }

            }
        }
    }
}