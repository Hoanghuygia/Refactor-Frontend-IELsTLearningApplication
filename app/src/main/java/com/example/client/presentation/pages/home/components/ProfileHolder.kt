package com.example.client.presentation.pages.home.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.client.domain.model.User
import com.example.client.presentation.navgraph.Route
import com.example.client.ui.theme.ClientTheme
import com.example.client.R

@Composable
fun ProfileHolder(currentUser: User, modifier: Modifier, onEvent: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        onClick = onEvent,
        modifier = modifier.padding(bottom = 32.dp)
    ) {
        Row(
            modifier = modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .fillMaxSize(),
                painter = painterResource(id = currentUser.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Welcome",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = currentUser.fullName,
                    fontWeight = FontWeight.Bold,
                    color = Color.Yellow,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 411, heightDp = 892)
@Composable
fun PreviewProfileHolder() {
    ClientTheme {
        val navController = rememberNavController()
        ProfileHolder(
            currentUser = User(
                email = "Test@gmail.com",
                fullName = "NPDQ",
                givenName = "Q",
                familyName = "N",
                avatar = R.drawable.avatar
            ), modifier = Modifier, onEvent = { navController.navigate(Route.ProfileScreen.route) })
    }
}