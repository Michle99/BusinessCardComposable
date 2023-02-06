package com.example.businesscard
import android.content.res.Configuration
import androidx.compose.material.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    BusinessCardInfo()
                }
            }
        }
    }
}

@Composable
fun BusinessCardInfo() {
    Row(Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LogoNameTitle("Michel Galvin", "Android Developer Manager")
            ContactInfo(phone = "6789098876", social = "@MicGav", email = "michelGav@mg.com")
        }
    }
}

@Composable
private fun ContactInfo(
    phone: String,
    social: String,
    email: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
    ) {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Icon(Icons.Rounded.Phone, contentDescription = "Phone Icon", tint = Color.Green)
                Spacer(modifier = Modifier.width(70.dp))
                Text(text = phone, color = Color.Black)
            }
        }
        Column {
            Row {
                Icon(Icons.Rounded.Share, contentDescription = "Share Icon", tint = Color.Green)
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = social, color = Color.Black)
            }
        }
        Column {
            Row {
                Icon(Icons.Rounded.Email, contentDescription = "Email icon", tint = Color.Green)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = email, color = Color.Black)
            }
        }

    }
}

@Composable
private fun LogoNameTitle(
    name: String,
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            val image = painterResource(id = R.drawable.andr128)
            Image(painter = image, contentDescription = "android logo")
            Text(
                text = "android",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 25.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 35.dp)
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Justify,
                color = Color.Black,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            )
            Text(
                text = title,
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                textAlign = TextAlign.Justify
            )
        }

    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0x154734,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardInfo()
    }
}