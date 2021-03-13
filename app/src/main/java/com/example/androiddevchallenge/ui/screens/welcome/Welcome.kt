package com.example.androiddevchallenge.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(welcomeScreenComplete: () -> Unit) {
    ScreenBackground {
        Column(
            modifier = Modifier
                .padding(top = 72.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(start = 88.dp, bottom = 48.dp),
                painter = painterResource(id = R.drawable.ic_light_welcome_illos),
                contentDescription = "leaf",
                contentScale = ContentScale.Crop
            )

            Image(painter = painterResource(id = R.drawable.ic_light_logo), contentDescription = "")
            Text(
                text = "Beautiful home garden solutions",
                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                style = MaterialTheme.typography.subtitle1
            )
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 40.dp)) {
                Text(text = "Create Account")
            }
            Text(text = "Login")
        }
    }
}

@Composable
fun ScreenBackground(content: @Composable () -> Unit) {
    Surface {
        Image(
            painter = painterResource(id = R.drawable.ic_light_welcome_bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        content()
    }
}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    MyTheme {
        WelcomeScreen(welcomeScreenComplete = { })
    }
}