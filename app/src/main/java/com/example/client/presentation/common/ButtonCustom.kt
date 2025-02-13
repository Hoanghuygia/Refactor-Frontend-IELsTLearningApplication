import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.client.R
import com.example.client.ui.theme.ClientTheme


@Composable
fun ButtonCustom(
    textContent: String,
    type: String,
    colorContainer: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (logoResId, textColor) = when (type.lowercase()) {
        "facebook" -> R.drawable.fb_logo to Color.White
        "gmail" -> R.drawable.gg_logo to Color.Black
        else -> null to Color.Black
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorContainer,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (logoResId != null) {
                Image(
                    painter = painterResource(id = logoResId),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(48.dp))
            }
            Text(
                text = textContent,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 411)
@Composable
fun PreviewCustomButton() {
    ClientTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ButtonCustom("Continue with Facebook", "facebook", Color(0xFF1877F2), onClick = {})
            ButtonCustom("Continue with Google", "gmail", Color.White, onClick = {})
        }
    }
}